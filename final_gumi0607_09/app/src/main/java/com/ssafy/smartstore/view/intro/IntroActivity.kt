package com.ssafy.smartstore.view.intro

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.messaging.FirebaseMessaging
import com.ssafy.smartstore.R
import com.ssafy.smartstore.databinding.ActivityIntroBinding
import com.ssafy.smartstore.view.home.HomeActivity

private const val TAG = "IntroActivity"

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    private lateinit var loginIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // FCM 노티 채널 설정
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setFCMChannel()
        }

        loginIntent = Intent(
            this@IntroActivity,
            HomeActivity::class.java
        ).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        Log.d("notidata", "${intent?.extras}")
        val bundle = Bundle()
        if (intent?.extras != null) {
            for (key: String in intent!!.extras!!.keySet()) {
                val value = intent!!.extras!!.get(key)
                if (key == "message") {
                    loginIntent.putExtra("notiData", value as String)
                    bundle.putString("notiData",value)
                }
                Log.d("notidata", "$value Key: " + key + "           Value: " + value);
            }
        }

        val navHostFragment =
            supportFragmentManager
                .findFragmentById(R.id.intro_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.setGraph(R.navigation.intro_graph, bundle)
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