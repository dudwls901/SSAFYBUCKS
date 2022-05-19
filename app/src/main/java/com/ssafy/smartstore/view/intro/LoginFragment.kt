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
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ssafy.smartstore.R
import com.ssafy.smartstore.data.local.dto.User
import com.ssafy.smartstore.data.remote.repository.UserRepository
import com.ssafy.smartstore.databinding.FragmentLoginBinding
import com.ssafy.smartstore.view.home.HomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

private const val TAG = "LoginFragment"

class LoginFragment : Fragment(), CoroutineScope {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var prefs: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefs = requireActivity().getSharedPreferences("data", AppCompatActivity.MODE_PRIVATE)

        //자동로그인
        autoLogin()

        // 뷰 초기화
        initViews(view)
    }

    //자동로그인
    private fun autoLogin() {
        val id = prefs.getString("id", "")!!
        val pw = prefs.getString("password", "")!!
        if (!id.equals("") && !pw.equals("")) login(id, pw)
    }

    private fun initViews(view: View) = with(binding) {

        navController = Navigation.findNavController(view)

        // 로그인 버튼
        btnLogin.setOnClickListener {
            val id = etID.text.toString()
            val pw = etPW.text.toString()
            login(id, pw)
        }

        // 조인 버튼
        btnJoin.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_joinFragment)
        }
    }

    // 로그인 수행
    private fun login(id: String, pw: String) {

        if (id.isNotEmpty() && pw.isNotEmpty()) {

            launch {
                val user = UserRepository.INSTANCE.login(User(id, pw)).body()
                Log.d(TAG, "login: ${user}")
                if (user == null) {
                    launch(Dispatchers.Main) {
                        Toast.makeText(
                            requireContext(),
                            "아이디, 비밀번호를 확인해주세요",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    // Preferences에 유저정보 저장
                    val editor = prefs.edit()
                    editor.putString("id", user.id)
                    editor.putString("name", user.name)
                    editor.putString("password", user.pass)
                    editor.commit()

                    launch(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "로그인 성공", Toast.LENGTH_SHORT)
                            .show()
                    }

                    Intent(
                        requireActivity(),
                        HomeActivity::class.java
                    ).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(this)
                    }

                }
            }
        } else {
            launch(Dispatchers.Main) {
                Toast.makeText(requireContext(), "아직 입력되지 않은 항목이 있습니다", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}