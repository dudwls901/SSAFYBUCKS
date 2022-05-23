package com.ssafy.admin_final_gumi0607_09.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.admin_final_gumi0607_09.R
import com.ssafy.admin_final_gumi0607_09.adapter.UserAdapter
import com.ssafy.admin_final_gumi0607_09.databinding.FragmentCustomerBinding
import com.ssafy.admin_final_gumi0607_09.viewmodel.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

class CustomerFragment : Fragment(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var binding: FragmentCustomerBinding
    private lateinit var adapter: UserAdapter

    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomerBinding.inflate(inflater, container, false)

        observeDatas()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel.getUserList()

        initViews()
    }

    private fun observeDatas() {
        userViewModel.userList.observe(viewLifecycleOwner) {
            updateUserList(it)
        }
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {
        // 유적 리사이클러뷰 어댑터 연결
        adapter = UserAdapter().apply {
            setHasStableIds(true)

            rvUser.adapter = this
            rvUser.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    //유적 리스트 데이터 업데이트
    private fun updateUserList(userList: List<HashMap<String, Any>>) {
        //어댑터 갱신
        Log.d("TAG", "${userList}: ")
        Collections.sort(
            userList,
            Comparator { t: Map<String, Any>, t2: Map<String, Any> ->
                val item1 = t.get("grade") as Map<String, Any>
                val item2 = t2.get("grade") as Map<String, Any>
                (item2.get("stamp") as Double - item1.get("stamp") as Double).toInt()
            })
        adapter.submitList(userList)
    }
}