package com.ssafy.smartstore.view.intro

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.smartstore.R
import com.ssafy.smartstore.data.local.dto.User
import com.ssafy.smartstore.data.remote.repository.UserRepository
import com.ssafy.smartstore.databinding.FragmentJoinBinding
import com.ssafy.smartstore.view.home.HomeActivity
import kotlinx.coroutines.*

private const val TAG = "JoinFragment"

class JoinFragment : Fragment(), CoroutineScope {

    private lateinit var binding: FragmentJoinBinding

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job
    private lateinit var prefs: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJoinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = requireActivity().getSharedPreferences("data", AppCompatActivity.MODE_PRIVATE)
        // 뷰 초기화
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
                                Toast.makeText(requireContext(), "회원가입 성공", Toast.LENGTH_SHORT)
                                    .show()
                                login(id, pw)
                            }
                        } else {
                            launch(Dispatchers.Main) {
                                Toast.makeText(requireContext(), "이미 등록된 회원", Toast.LENGTH_SHORT)
                                    .show()

                            }
                        }
                    }
                } catch (e: Exception) {
                    Log.d(TAG, "회원가입 실패 $e")
                    Toast.makeText(requireContext(), "오류가 발생하였습니다", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "아직 입력되지 않은 항목이 있습니다", Toast.LENGTH_SHORT).show()
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
                                requireContext(),
                                "사용 가능한 아이디입니다",
                                Toast.LENGTH_SHORT
                            ).show()
                        else
                            Toast.makeText(requireContext(), "중복된 아이디입니다", Toast.LENGTH_SHORT)
                                .show()
                    }
                }
            }
        }
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
                Log.d(TAG, "login: ${user}")
                if (user == null) {

                    Toast.makeText(
                        requireContext(),
                        "아이디, 비밀번호를 확인해주세요",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {
                    // Preferences에 유저정보 저장
                    val editor = prefs.edit()
                    editor.putString("id", user!!.id)
                    editor.putString("name", user!!.name)
                    editor.putString("password", user!!.pass)
                    editor.commit()

//                    launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "로그인 성공", Toast.LENGTH_SHORT)
                        .show()
//                    }

                    Intent(requireContext(),
                        HomeActivity::class.java
                    ).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(this)
                    }

                }
            }
        } else {
//            launch(Dispatchers.Main) {
            Toast.makeText(requireContext(), "아직 입력되지 않은 항목이 있습니다", Toast.LENGTH_SHORT)
                .show()
//            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            JoinFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}