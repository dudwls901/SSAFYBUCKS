package com.ssafy.admin_final_gumi0607_09.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.ssafy.admin_final_gumi0607_09.R
import com.ssafy.admin_final_gumi0607_09.databinding.ActivityMainBinding
import com.ssafy.smartstore.data.remote.repository.TokenRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    companion object{
        const val userId = "admin"
        const val TAG = "MainActivity_sss"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uploadDeviceToken()

        // 바텀 네비게이션 초기 설정
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavi, navController)

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



}