package com.ssafy.smartstore.view.home

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.R
import com.ssafy.smartstore.StoreApplication
import com.ssafy.smartstore.StoreApplication.Companion.customAdd
import com.ssafy.smartstore.StoreApplication.Companion.orderTable
import com.ssafy.smartstore.adapter.OrderDetailAdapter
import com.ssafy.smartstore.databinding.ActivityShoppingListBinding
import com.ssafy.smartstore.model.OrderDetail
import com.ssafy.smartstore.model.OrderInfo
import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.data.local.repository.OrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.ssafy.smartstore.listener.ShoppingListDeleteClickListener
import com.ssafy.smartstore.data.remote.dto.Order
import com.ssafy.smartstore.util.WindowState.SHOPPINGLIST

// F06: 주문 관리 - 상품 주문 - 로그인한 사용자는 상품 상세 화면 에서 n개를 선정하여 장바구니에 등록할 수 있다. 로그인 한 사용자만 자기의 계정으로 구매를 처리할 수 있다.
// 장바구니 화면

private const val TAG = "ShoppingListActivity_싸피"

class ShoppingListActivity : AppCompatActivity(), ShoppingListDeleteClickListener {
    private lateinit var binding: ActivityShoppingListBinding

    private lateinit var adapter: OrderDetailAdapter
    private lateinit var orderList: MutableList<OrderDetail>
    private var orderInfo: OrderInfo? = null
    private lateinit var orderInfo2: OrderProduct
    private lateinit var shoppingList: ArrayList<OrderProduct>

    private lateinit var orderRepo: OrderRepository

    private var user_id = ""

    private lateinit var nfcAdapter: NfcAdapter
    private lateinit var pIent: PendingIntent
    private lateinit var filters: Array<IntentFilter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        binding = ActivityShoppingListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        orderRepo = OrderRepository.getInstance()

        val prefs = getSharedPreferences("data", MODE_PRIVATE)
        user_id = prefs.getString("id", "") ?: ""

        initOrderDetailList()


        shoppingList = StoreApplication.shoppingList

        val bundle = intent.getBundleExtra("orderInfo")
        orderInfo = bundle?.getParcelable<OrderInfo>("orderInfo") as OrderInfo

        if (orderInfo != null) {
            shoppingList.customAdd(orderInfo!!.orderProductList) // List<orderProduct>
        }

        val data2 = intent.getSerializableExtra("orderProduct")

        if (data2 != null) {
            orderInfo2 = data2 as OrderProduct
            shoppingList.customAdd(orderInfo2)
        }

        initViews()

        initNFC()
    }

    override fun onResume() {
        super.onResume()
        nfcAdapter.enableForegroundDispatch(this, pIent, filters, null)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.e("INFO___", "onNewIntent")
        if (intent?.action != null
            && (intent.action.equals(NfcAdapter.ACTION_NDEF_DISCOVERED)
                    || intent.action.equals(NfcAdapter.ACTION_TAG_DISCOVERED))
        ) {
            processIntent(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        nfcAdapter.disableForegroundDispatch(this)
    }


    private fun initOrderDetailList() {
        orderList = mutableListOf(
            OrderDetail(1, "아메리카노", 4000, 2),
            OrderDetail(2, "아메리카", 5000, 3),
            OrderDetail(3, "아메리", 6000, 1),
            OrderDetail(4, "아메", 7000, 3),
            OrderDetail(5, "아", 8000, 2),
        )
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {

        var priceSum = 0
        var orderCount = 0

        for (orderProduct in shoppingList) {
            orderCount += orderProduct.quantity
            priceSum += orderProduct.quantity * orderProduct.product.price
        }

        tvPriceSum.text = "총 ${orderCount}개"
        tvOrderCount.text = "${priceSum}원"

        // 주문상세 리사이클러뷰 연결
        adapter = OrderDetailAdapter(SHOPPINGLIST, this@ShoppingListActivity).apply {
            setHasStableIds(true)
            submitList(shoppingList)

            rvOrderList.adapter = this
            rvOrderList.layoutManager =
                LinearLayoutManager(this@ShoppingListActivity, LinearLayoutManager.VERTICAL, false)
        }

        // 주문하기 버튼
        btnOrder.setOnClickListener {
            // {orders=[{id=1, name=coffee1, type=coffee, price=1, img=coffee1.png, count=2}, {id=5, name=coffee5, type=coffee, price=5, img=coffee5.png, count=3}], userId=123}
            // orders의 id : prodcutId, count : quantity
            if (!StoreApplication.shoppingList.isEmpty()) {
                val data = StoreApplication.shoppingList

                if (orderTable == "") {
                    val builder =
                        AlertDialog.Builder(this@ShoppingListActivity, R.style.MyDialogTheme)
                    builder.setTitle("알림")
                    builder.setMessage("Table NFC를 먼저 찍어주세요")
                    builder.setIcon(R.mipmap.ic_launcher)

                    builder.setPositiveButton("확인", null)
                    builder.show()
                } else {
                    val order = Order(user_id, orderTable)
                    val orderDetails = mutableListOf<com.ssafy.smartstore.data.remote.dto.OrderDetail>()
                    data.forEach {
                        val orderDetail =
                            com.ssafy.smartstore.data.remote.dto.OrderDetail(it.product.id, it.quantity)
                        orderDetails.add(orderDetail)
                    }
                    order.details = orderDetails

                    StoreApplication.shoppingList = ArrayList<OrderProduct>()

                    CoroutineScope(Dispatchers.Main).launch {
                        com.ssafy.smartstore.data.remote.repository.OrderRepository.INSTANCE.makeOrder(
                            order
                        )
                        Toast.makeText(this@ShoppingListActivity, "주문이 완료되었습니다", Toast.LENGTH_SHORT)
                            .show()
                        finish()
                    }

                    Intent(this@ShoppingListActivity, HomeActivity::class.java).apply {
                        putExtra("refresh", true)
                        startActivity(this)
                        finish()
                    }
                }
            } else {
                Toast.makeText(this@ShoppingListActivity, "상품을 담아주세요", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
        }
    }


    override fun onShoppingListDeleteClickListener(position: Int) {
        shoppingList.removeAt(position)

        initViews()

    }

    private fun initNFC() {
        nfcAdapter = NfcAdapter.getDefaultAdapter(this).apply {
            if (this == null) finish()
        }
        val intent = Intent(this, ShoppingListActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        pIent = PendingIntent.getActivity(this, 1, intent, 0)
        val tag_filter = IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED)
        filters = arrayOf(tag_filter)
    }

    fun processIntent(intent: Intent) {

        val action = intent.action

        // 1. 인텐트에서 NdefMessage 배열 데이터를 가져온다
        val rawMsg = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)

        // 2. Data를 변환
        if (rawMsg != null) {
            val msgArr = arrayOfNulls<NdefMessage>(rawMsg.size)

            for (i in rawMsg.indices) {
                msgArr[i] = rawMsg[i] as NdefMessage?
            }

            // 3. NdefMessage에서 NdefRecode -> payload
            val recInfo = msgArr[0]!!.records[0]

            // Record type check: text, uri
            val data = recInfo.type
            val recType = String(data)

//            binding.infoTv.text = recType   // T, U

            if (recType.equals("T")) {          // text인 경우
                val payload = recInfo.payload
                val text = String(payload, 3, payload.size - 3)
                val num = String(payload, payload.size - 2, 2).toInt()
                Log.d(TAG, "processIntent: $num")
                orderTable = text
                Toast.makeText(this, "${num}번 테이블 번호가 등록 되었습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}