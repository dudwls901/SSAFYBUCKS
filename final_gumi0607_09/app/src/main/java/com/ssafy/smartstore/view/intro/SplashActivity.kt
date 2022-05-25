package com.ssafy.smartstore.view.intro

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ssafy.smartstore.data.local.dto.User
import com.ssafy.smartstore.data.remote.repository.UserRepository
import com.ssafy.smartstore.databinding.ActivitySplashBinding
import com.ssafy.smartstore.view.home.HomeActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var binding: ActivitySplashBinding

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var prefs: SharedPreferences
    private var notiData: String? = null

    private lateinit var loginIntent: Intent
    private lateinit var homeIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        prefs = this.getSharedPreferences("data", AppCompatActivity.MODE_PRIVATE)


        loginIntent = Intent(
            this,
            IntroActivity::class.java
        )
        homeIntent = Intent(
            this,
            HomeActivity::class.java
        )


        Log.d("notidata", "${intent?.extras}")
        val bundle = Bundle()
        if (intent?.extras != null) {
            for (key: String in intent!!.extras!!.keySet()) {
                val value = intent!!.extras!!.get(key)
                if (key == "message") {
                    loginIntent.putExtra("notiData", value as String)
                    homeIntent.putExtra("notiData", value as String)
                    bundle.putString("notiData",value)
                }
                Log.d("notidata", "$value Key: " + key + "           Value: " + value);
            }
        }

        launch {
            delay(1500L)
            if(autoLogin()){
                return@launch
            }
            Log.d("splash", "onCreate: 여기와???")
            startActivity(loginIntent)
            finish()
        }


    }

    //자동로그인
    private fun autoLogin(): Boolean {
        val id = prefs.getString("id", "")!!
        val pw = prefs.getString("password", "")!!
        if (!id.equals("") && !pw.equals("")) {
            login(id, pw)
            return true
        }
        return false
    }

    // 로그인 수행
    private fun login(id: String, pw: String) {

        if (id.isNotEmpty() && pw.isNotEmpty()) {

            launch {
                var user: User? = null
                val job = launch {
                    user = UserRepository.INSTANCE.login(User(id, pw)).body()
                }
                job.join()
                Log.d("splash", "login: ${user}")
                if (user != null) {
                    startActivity(homeIntent)
                    finish()
                }
            }
        }
    }


}