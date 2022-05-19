package com.ssafy.smartstore.fragment

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.OrderDetailActivity
import com.ssafy.smartstore.ShoppingListActivity
import com.ssafy.smartstore.adapter.NotiAdapter
import com.ssafy.smartstore.adapter.OrderListAdapter
import com.ssafy.smartstore.databinding.FragmentHomeBinding
import com.ssafy.smartstore.dto.OrderInfo
import com.ssafy.smartstore.dto.OrderProduct
import com.ssafy.smartstore.listener.NotiDeleteClickListener
import com.ssafy.smartstore.listener.OrderListClickListener
import com.ssafy.smartstore.local.dto.Product
import com.ssafy.smartstore.local.repository.NotiRepository
import com.ssafy.smartstore.local.repository.OrderDetailRepository
import com.ssafy.smartstore.local.repository.OrderRepository
import com.ssafy.smartstore.local.repository.UserRepository
import com.ssafy.smartstore.remote.dto.OrderInfoResponse
import com.ssafy.smartstore.viewmodel.HomeViewModel
import com.ssafy.smartstore.viewmodel.OrderViewModel
import kotlinx.coroutines.*


private const val TAG = "HomeFragment_싸피"

@RequiresApi(Build.VERSION_CODES.N)
class HomeFragment : Fragment(), CoroutineScope, OrderListClickListener, NotiDeleteClickListener {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var userId: String
    private lateinit var userName: String
    private lateinit var binding: FragmentHomeBinding
    private lateinit var orderAdapter: OrderListAdapter
    private lateinit var notiAdapter: NotiAdapter
    private lateinit var notiRepo: NotiRepository


    private val homeViewModel: HomeViewModel by activityViewModels()
    private val orderViewModel: OrderViewModel by activityViewModels()



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val prefs = requireActivity().getSharedPreferences("data", Context.MODE_PRIVATE)
        userId = prefs.getString("id", "") ?: ""
        userName = prefs.getString("name", "") ?: ""

        notiRepo = NotiRepository.getInstance(requireContext())

        notiAdapter = NotiAdapter(this@HomeFragment)

        observeDatas()
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userId?.let {
            orderViewModel.getOrderMonth(it)
            launch {
                val notiList = notiRepo.select(userId)
                homeViewModel.updateNotiList(notiList)
            }
        }

    }

    private fun observeDatas() {
        orderViewModel.responseGetOrderMonth.observe(viewLifecycleOwner) {
            if (it.isSuccessful) {
                val response = it.body()
                response?.let {
                    Log.d(TAG, "observeDatas: $it")
                    getOrderInfoList(it)
                }
            } else {

            }
        }
        Log.d(TAG, "onViewCreated: noti ${userId}")
        homeViewModel.notiList.observe(viewLifecycleOwner) {
            Log.d(TAG, "onCreateView: noti change ${it.joinToString()}")
            notiAdapter.submitList(it)
            notiAdapter.notifyDataSetChanged()
        }
        initViews()
    }


    fun getOrderInfoList(orderInfoResponseList: List<OrderInfoResponse>) {
         var orderInfoList= mutableListOf<OrderInfo>()
        val quantityMap = mutableMapOf<Int, MutableMap<Int,Int>>()

        //orderList가져오기
        var orderList = orderInfoResponseList
        val productMap = mutableMapOf<Int, MutableMap<Int,Product>>()
        val productList = ArrayList<Pair<Int,Product>>()
        for (order in orderList) {
            if(quantityMap[order.o_id].isNullOrEmpty()){
                quantityMap[order.o_id]= mutableMapOf()
            }
            quantityMap.getOrDefault(order.o_id, mutableMapOf()).apply {
                this.put(order.p_id,
                    this.getOrDefault(order.p_id,0)+order.quantity
                )
            }

            val product = Product(
                order.p_id,
                order.name,
                order.type,
                order.price,
                order.img
            )
            productList.add(Pair(order.o_id,product))

        }
        orderList = orderList.distinctBy { it.o_id }
        Log.d(TAG, "orderList: $orderList")
        Log.e(TAG, "productList ${productList}", )
        for (order in orderList) {
            val orderProductList = ArrayList<OrderProduct>()
            productList.forEach {
                val (id,product) = it
                if (order.o_id == id) {
                    orderProductList.add(
                        OrderProduct(
                            quantity = quantityMap[order.o_id]!!.getOrDefault(product.id,0)!!,
                            product = product
                        )
                    )
                }
            }
            orderInfoList.add(
                OrderInfo(
                    id = order.o_id,
                    date = order.order_time,
                    orderProductList = orderProductList
                )
            )
        }
        orderViewModel.updateOrderInfoList(orderInfoList)
        orderInfoList = if (orderInfoList.size > 5) orderInfoList.subList(0, 4) else orderInfoList

        updateOrderList(orderInfoList)
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {

        tvHeaderName.text = userName

        // 최근주문 리사이클러뷰 어댑터 연결
        orderAdapter = OrderListAdapter(
            com.ssafy.smartstore.global.windowState.HOME,
            this@HomeFragment
        ).apply {
            setHasStableIds(true)

            rvRecentOrder.adapter = this
            rvRecentOrder.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        // 알림판 리사이클러뷰 어댑터 연결
        notiAdapter = NotiAdapter(this@HomeFragment).apply {
            rvNoti.adapter = this
            rvNoti.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

    }

    //주문 리스트 데이터 업데이트
    private fun updateOrderList(orderInfoList: List<OrderInfo>) {
        //어댑터 갱신
        orderAdapter.submitList(orderInfoList)
        binding.rvRecentOrder.adapter = orderAdapter

    }

    override fun onOrderListClickListener(orderInfo: OrderInfo) {
        val intent = Intent(requireContext(), OrderDetailActivity::class.java)
        intent.putExtra("orderInfo",orderInfo)
        startActivity(intent)
    }

    override fun onOrderListCartClickListener(orderInfo: OrderInfo) {
        val intent = Intent(requireContext(), ShoppingListActivity::class.java)
        intent.putExtra("orderInfo",orderInfo)
        startActivity(intent)
    }

    override fun onNotiDeleteClickListener(id: Int) {
        launch {
            withContext(Dispatchers.Main) {
                notiRepo.delete(id)
            }
            val notiList = notiRepo.select(userId)
            homeViewModel.updateNotiList(notiList)
        }
    }
}