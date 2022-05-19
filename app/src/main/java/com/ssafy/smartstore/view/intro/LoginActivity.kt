package com.ssafy.smartstore.view.intro

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.firebase.messaging.FirebaseMessaging
import com.ssafy.smartstore.databinding.ActivityLoginBinding
import com.ssafy.smartstore.data.local.dto.User
import com.ssafy.smartstore.data.remote.repository.UserRepository
import com.ssafy.smartstore.view.home.HomeActivity
import kotlinx.coroutines.*

// F04: 회원 관리 - 회원 로그인 - 추가된 회원 정보를 이용해서 로그인 할 수 있다. 로그아웃을 하기 전까지 앱을 실행시켰 을 때 로그인이 유지되어야 한다.
// F05: 회원 관리 - 회원 로그아웃

private const val TAG = "LoginActivity_싸피"

class LoginActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job
    private var notiData: String? = null
    private lateinit var binding: ActivityLoginBinding

    //    private lateinit var userRepo: UserRepository
    private lateinit var loginIntent: Intent
    private lateinit var prefs: SharedPreferences

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        userRepo = UserRepository.getInstance(applicationContext)

        prefs = getSharedPreferences("data", MODE_PRIVATE)


        //자동로그인
        val id = prefs.getString("id", "")!!
        val pw = prefs.getString("password", "")!!
        if (!id.equals("") && !pw.equals("")) login(id, pw)

        loginIntent = Intent(
            this@LoginActivity,
            HomeActivity::class.java
        ).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }


        //백그라운드 데이터 수신은 noti 말고 data에 값 담아서 푸시 보내야 하므로 서버 구현해야 함
        if (intent?.extras != null) {
            for (key: String in intent!!.extras!!.keySet()) {
                val value = intent!!.extras!!.get(key)
                if (key == "message") {
                    loginIntent.putExtra("notiData", value as String)
                }
                Log.d("notidata", "$value Key: " + key + "           Value: " + value);
            }
        }
        initViews()

        //FCM 토큰 받아오기
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

    private fun initViews() = with(binding) {

        // 로그인 버튼
        btnLogin.setOnClickListener {
            val id = etID.text.toString()
            val pw = etPW.text.toString()
            login(id, pw)
        }

        btnJoin.setOnClickListener {
            Intent(this@LoginActivity, JoinActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun login(id: String, pw: String) {

        if (id.isNotEmpty() && pw.isNotEmpty()) {

            launch {
                val user = UserRepository.INSTANCE.login(User(id, pw)).body()
                Log.d(TAG, "login: ${user}")
                if (user == null) {
                    launch(Dispatchers.Main) {
                        Toast.makeText(
                            this@LoginActivity,
                            "아이디, 비밀번호를 확인해주세요",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    // Preferences에 유저정보 저장
                    val prefs = getSharedPreferences("data", MODE_PRIVATE)
                    val editor = prefs.edit()
                    editor.putString("id", user.id)
                    editor.putString("name", user.name)
                    editor.putString("password", user.pass)
                    editor.commit()

                    launch(Dispatchers.Main) {
                        Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT)
                            .show()

                        startActivity(loginIntent)
                    }
                }
            }
        } else {
            launch(Dispatchers.Main) {
                Toast.makeText(this@LoginActivity, "아직 입력되지 않은 항목이 있습니다", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}