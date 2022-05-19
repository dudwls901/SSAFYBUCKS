package com.ssafy.smartstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ssafy.smartstore.databinding.ActivityJoinBinding
import com.ssafy.smartstore.local.dto.User
import com.ssafy.smartstore.remote.repository.UserRepository
import kotlinx.coroutines.*

// F02: 회원 관리 - 회원 정보 추가 회원 가입 - 회원 정보를 추가할 수 있다.
// F03: 회원 관리 - 회원 아이디 중복 확인 - 회원 가입 시 아이디가 중복되는지 여부를 확인할 수 있다.

private const val TAG = "JoinActivity_싸피"

class JoinActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initViews()

    }

    private fun initViews() = with(binding) {

        // 회원가입 버튼
        btnJoin.setOnClickListener {

            var id = etID.text.toString()
            var pw = etPW.text.toString()
            var name = etNickName.text.toString()

            if (id.isNotEmpty() && pw.isNotEmpty() && name.isNotEmpty()) {
                try {
                    launch(Dispatchers.IO) {
                        val result = UserRepository.INSTANCE.insert(User(id, name, pw)).body()!!
                        if (result > 0) {
                            launch(Dispatchers.Main) {
                                Toast.makeText(this@JoinActivity, "회원가입 성공", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        } else {
                            launch(Dispatchers.Main) {
                                Toast.makeText(this@JoinActivity, "이미 등록된 회원", Toast.LENGTH_SHORT)
                                    .show()

                            }
                        }
                    }
                } catch (e: Exception) {
                    Log.d(TAG, "회원가입 실패 $e")
                }
            } else {
                Toast.makeText(this@JoinActivity, "아직 입력되지 않은 항목이 있습니다", Toast.LENGTH_SHORT).show()
            }
        }

        // 중복 검사
        btnCheck.setOnClickListener {

            var id = etID.text.toString()
            if (id.isNotEmpty()) {
                launch {
                    var result = false

                    UserRepository.INSTANCE.isUsedId(id).also {
                        Log.d(TAG, "initViews: ${it}")
                        if (it.isSuccessful) {
                            result = it.body()!!
                            Log.d(TAG, "initViews: ${it.body()}")
                        }
                    }

                    withContext(Dispatchers.Main) {
                        if (!result)
                            Toast.makeText(
                                this@JoinActivity,
                                "사용 가능 아이디",
                                Toast.LENGTH_SHORT
                            ).show()
                        else
                            Toast.makeText(this@JoinActivity, "중복된 아이디", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
