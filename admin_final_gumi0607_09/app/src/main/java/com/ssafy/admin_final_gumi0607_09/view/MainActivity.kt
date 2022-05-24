package com.ssafy.admin_final_gumi0607_09.view

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.nfc.NfcAdapter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.ssafy.admin_final_gumi0607_09.R
import com.ssafy.admin_final_gumi0607_09.data.local.entity.Noti
import com.ssafy.admin_final_gumi0607_09.data.local.entity.TempNoti
import com.ssafy.admin_final_gumi0607_09.data.local.respositroy.NotiRepository
import com.ssafy.admin_final_gumi0607_09.databinding.ActivityMainBinding
import com.ssafy.admin_final_gumi0607_09.viewmodel.OrderViewModel
import com.ssafy.smartstore.data.remote.repository.TokenRepository
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), CoroutineScope  {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var notiRepo: NotiRepository
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var notiData: String? = null
    private val orderViewModel: OrderViewModel by viewModels()
    companion object{
        const val userId = "admin"
        const val TAG = "MainActivity_sss"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.vm = orderViewModel
        binding.lifecycleOwner = this
        notiRepo = NotiRepository.getInstance(this)


        uploadDeviceToken()
        observeDatas()
        initViews()


        // FCM 노티 채널 설정
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setFCMChannel()
        }

        //background push 데이터 받기
        Log.d("notidata", "${intent?.extras}")
        if (intent?.extras != null) {
            var userName=""
            var message=""
            for (key: String in intent!!.extras!!.keySet()) {
                val value = intent!!.extras!!.get(key)
                if (key == "message") {
                    message=value.toString()
                }
                if( key =="title"){
                    userName = value.toString()
                }
            }
            launch {
                withContext(Dispatchers.Main) {
                    notiRepo.insert(Noti(userName, message))
                }
                val notiList = notiRepo.select()
                Log.d(TAG, "onCreate: ${notiList}")
                orderViewModel.updateNotiList(notiList)
            }
        }
        
        getNotiList()
    }


    private fun initViews() = with(binding){

        // 바텀 네비게이션 초기 설정
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavi, navController)


        mainIbNoti.setOnClickListener {
            val tempNotiSize = orderViewModel.tempNotiList.value!!.size
            launch {

                withContext(Dispatchers.IO) {
                    orderViewModel.notiList.value?.forEach {
                        if (it.id > tempNotiSize) {
                            notiRepo.insertTemp(TempNoti(it.u_id, it.data))
                        }
                    }
                }
                val bundle = Bundle()
                bundle.putParcelableArray("notiList", orderViewModel.notiList.value!!.toTypedArray())
                startActivity(Intent(this@MainActivity, NotiListActivity::class.java).apply {
                    putExtra("notiList",bundle)
                })
            }
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if(orderViewModel.notiList.value!!.size != orderViewModel.tempNotiList.value?.size) {
            orderViewModel.updateTouchCount()
        }
        return super.dispatchTouchEvent(ev)

    }


    private fun observeDatas(){
        orderViewModel.notiList.observe(this){
            Log.d(TAG, "observeDatas: ${it.size} ${orderViewModel.tempNotiList.value?.size}")
            if(it.size != orderViewModel.tempNotiList.value?.size){
                val shake  = AnimationUtils.loadAnimation(this, R.anim.shake)
                binding.mainIbNoti.startAnimation(shake)
            }
        }
        orderViewModel.touchCount.observe(this){
            if(it%30==0 && it!=0){
                val shake  = AnimationUtils.loadAnimation(this, R.anim.shake)
                binding.mainIbNoti.startAnimation(shake)
            }
        }

        orderViewModel.loading.observe(this){
            if(it){
                binding.pbLoadingBar.visibility = View.VISIBLE
            }
            else{
                binding.pbLoadingBar.visibility = View.GONE
            }
        }
    }

    private fun getNotiList(){
        launch {
            val notiList = notiRepo.select()
            val tempNotiList = notiRepo.selectTemp()
            orderViewModel.updateTempNotiList(tempNotiList)
            orderViewModel.updateNotiList(notiList)

        }
    }

    private fun uploadDeviceToken(){
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

    //foreground push
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        notiData = intent?.getStringExtra("notiData")
        Log.d(TAG, "notidata onnewIntent: $notiData")
        notiData?.let {
            launch {
                withContext(Dispatchers.Main) {
                    notiRepo.insert(Noti(it.substring(0, it!!.indexOf("님")), it))
                }
                notiRepo.select()

                orderViewModel.updateNotiList(notiRepo.select())
            }
        }

    }

    // FCM 노티 채널 설정
    @RequiresApi(Build.VERSION_CODES.O)
    private fun setFCMChannel() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (!it.isSuccessful) {
                Log.d(TAG, "실패: ${it.exception}")
            } else {
                Log.d(TAG, "성공: ${it.result}")
            }
        }
        createNotiChannel("ssafy_id", "ssafy")
    }

    //오레오 이상에서만 동작하는 함수
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotiChannel(channelId: String, channelName: String) {

        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, channelName, importance)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

    }

}