package com.ssafy.smartstore.view.home

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RemoteException
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.ssafy.smartstore.R
import com.ssafy.smartstore.databinding.ActivityHomeBinding
import com.ssafy.smartstore.data.local.dto.Noti
import com.ssafy.smartstore.data.local.repository.NotiRepository
import com.ssafy.smartstore.data.remote.repository.TokenRepository
import com.ssafy.smartstore.util.ImageConverter
import com.ssafy.smartstore.viewmodel.HomeViewModel
import com.ssafy.smartstore.viewmodel.OrderViewModel
import kotlinx.coroutines.*
import org.altbeacon.beacon.*

private const val TAG = "HomeActivity_싸피"

class HomeActivity : AppCompatActivity(), CoroutineScope, BeaconConsumer {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var dialogView: Dialog
    private var isOnDialog = false

    private lateinit var binding: ActivityHomeBinding
    private lateinit var notiRepo: NotiRepository

    private lateinit var userId: String
    private lateinit var userName: String

    private var notiData: String? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private val orderViewModel: OrderViewModel by viewModels()


    //비콘관련
    private val STORE_ID = 1
    private val STORE_DISTANCE = 10

    private lateinit var beaconManager: BeaconManager
    private val region = Region("altbeacon", null, null, null)

    private lateinit var bluetoothManager: BluetoothManager
    private var bluetoothAdapter: BluetoothAdapter? = null
    private var needBLERequest = true

    private val PERMISSIONS_CODE = 100

    // 모든 퍼미션 관련 배열
    private val requiredPermissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notiRepo = NotiRepository.getInstance(this)

        initViews()

        val prefs = this.getSharedPreferences("data", Context.MODE_PRIVATE)
        userId = prefs.getString("id", "") ?: ""
        userName = prefs.getString("name", "") ?: ""

        //background push 데이터 받기
        notiData = intent?.getStringExtra("notiData")
        Log.d(TAG, "notidata onCreate: $notiData")
        notiData?.let {
            launch {
                withContext(Dispatchers.Main) {
                    notiRepo.insert(Noti(userId, it))
                }
                val notiList = notiRepo.select(userId)
                Log.d(TAG, "onCreate: ${notiList}")
                homeViewModel.updateNotiList(notiList)

            }
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                requiredPermissions,
                PERMISSIONS_CODE
            )
        }

        beaconManager = BeaconManager.getInstanceForApplication(this)
        beaconManager.beaconParsers.add(BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"))
        bluetoothManager = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter

        startScan()


        // FCM 토큰 수신
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG + "FCM", "FCM 토큰 얻기에 실패하였습니다.", task.exception)
                return@OnCompleteListener
            }

            // token 전송
            CoroutineScope(Dispatchers.Main).launch {
                TokenRepository.INSTANCE.uploadToken(userId, task.result ?: "task.result is null")
            }
            Log.d(TAG + "FCM", "token: ${task.result ?: "task.result is null"}")

        })
    }

    override fun onStart() {
        super.onStart()
        // 장바구니에서 돌아왔는지 체크
        val refresh = intent?.getBooleanExtra("refresh", false)
        Log.d(TAG, "onCreate: $refresh")
        if (refresh == true) {
            orderViewModel.getOrderMonth(userId)
        }
    }

    // 꼭 Destroy를 시켜서 beacon scan을 중지 시켜야 한다.
    // beacon scan을 중지 하지 않으면 일정 시간 이후 다시 scan이 가능하다.
    override fun onDestroy() {
        beaconManager.stopMonitoringBeaconsInRegion(region)
        beaconManager.stopRangingBeaconsInRegion(region)
        beaconManager.unbind(this)
        super.onDestroy()
    }

    @SuppressLint("SetTextI18n")
    override fun onBeaconServiceConnect() {

        beaconManager.addMonitorNotifier(object : MonitorNotifier {

            override fun didEnterRegion(region: Region?) {
                try {
                    Log.d(TAG, "비콘을 발견하였습니다.------------${region.toString()}")
                    beaconManager.startRangingBeaconsInRegion(region!!)
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
            }

            override fun didExitRegion(region: Region?) {
                try {
                    Log.d(TAG, "비콘을 찾을 수 없습니다.")
                    beaconManager.stopRangingBeaconsInRegion(region!!)
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
            }

            override fun didDetermineStateForRegion(i: Int, region: Region?) {}
        })

        beaconManager.addRangeNotifier { beacons, region ->
            for (beacon in beacons) {
                // Major, Minor로 Beacon 구별, 1미터 이내에 들어오면 메세지 출력

                if (isYourBeacon(beacon)) {
                    // 한번만 띄우기 위한 조건
                    Log.d(
                        TAG,
                        "distance: " + beacon.distance + " Major : " + beacon.id2 + ", Minor" + beacon.id3
                    )
//                    val distance = Math.pow(12.0*1.5*(rssi))
                    runOnUiThread {

                        if (!isOnDialog) {
                            if (beacon.distance > 1.0) {
//                                binding.distanceTextView.text = "가맹점을 찾을 수 없습니다."
                            } else {
                                isOnDialog = true
                                orderViewModel.orderInfoList.value?.get(0)?.let {
                                    it.orderProductList?.let {
                                        it[0]?.let {
                                            showStoreDialog(
                                                it.product.name,
                                                it.product.img,
                                                it.product.price
                                            )

                                        }
                                    }
                                }
//                                binding.distanceTextView.text =
//                                    "거리 : ${String.format("%.5f", beacon.distance)}m"
                            }
                        }
                    }
                }
            }

            if (beacons.isEmpty()) {

            }
        }

        try {

            beaconManager.startMonitoringBeaconsInRegion(region)


        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    // 찾고자 하는 Beacon이 맞는지, 정해둔 거리 내부인지 확인
    private fun isYourBeacon(beacon: Beacon): Boolean {
//        return (beacon.id2.toString() == BEACON_MAJOR &&
//                beacon.id3.toString() == BEACON_MINOR &&
//                beacon.distance <= STORE_DISTANCE
//                )
        return (beacon.distance <= STORE_DISTANCE)
    }

    // Beacon Scan 시작
    private fun startScan() {
        // 블루투스 Enable 확인
        if (!isEnableBLEService()) {
            requestEnableBLE()
            Log.d(TAG, "startScan: 블루투스가 켜지지 않았습니다.")
            return
        }

        // 위치 정보 권한 허용 및 GPS Enable 여부 확인
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                requiredPermissions,
                PERMISSIONS_CODE
            )
        }
        Log.d(TAG, "startScan: beacon Scan start")

        // Beacon Service bind
        beaconManager.bind(this@HomeActivity)
    }


    // 블루투스 켰는지 확인
    private fun isEnableBLEService(): Boolean {
        if (!bluetoothAdapter!!.isEnabled) {
            return false
        }
        return true
    }

    // 블루투스 ON/OFF 여부 확인 및 키도록 하는 함수
    private fun requestEnableBLE() {
        val callBLEEnableIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        requestBLEActivity.launch(callBLEEnableIntent)
        Log.d(TAG, "requestEnableBLE: ")
    }

    private val requestBLEActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        // 사용자의 블루투스 사용이 가능한지 확인
        if (isEnableBLEService()) {
            needBLERequest = false
            startScan()
        }
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {

        // 바텀 네비게이션 초기 설정
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavi, navController)
    }

    //foreground push
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        notiData = intent?.getStringExtra("notiData")
        Log.d(TAG, "notidata onnewIntent: $notiData")
        notiData?.let {
            launch {
                withContext(Dispatchers.Main) {
                    notiRepo.insert(Noti(userId, it))
                }
                notiRepo.select(userId)

                homeViewModel.updateNotiList(notiRepo.select(userId))
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun showStoreDialog(name: String, img: String, price: Int) {
        isOnDialog = true
//        getStoreInfo()
        dialogView = Dialog(this)
        dialogView.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(com.ssafy.smartstore.R.layout.dialog_order_info)
            setCancelable(false)
            show()
        }
        val imageView = dialogView.findViewById<ImageView>(R.id.iv_dialog_order_info_image)
        val nameTextView = dialogView.findViewById<TextView>(R.id.tv_dialog_order_info_name)
        val priceTextView = dialogView.findViewById<TextView>(R.id.tv_dialog_order_info_price)
        val submitButton = dialogView.findViewById<Button>(R.id.btn_submit)
        imageView.clipToOutline = true
        ImageConverter.imageMap[img]?.let {
            imageView.setImageResource(
                it
            )
            nameTextView.text = name
            priceTextView.text = "${price}원"


            submitButton.setOnClickListener {
                isOnDialog = false
                dialogView.dismiss()
            }
        }
    }

}