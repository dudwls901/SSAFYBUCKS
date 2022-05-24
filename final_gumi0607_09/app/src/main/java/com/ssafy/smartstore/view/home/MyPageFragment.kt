package com.ssafy.smartstore.view.home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.adapter.OrderListAdapter
import com.ssafy.smartstore.databinding.FragmentMyPageBinding
import com.ssafy.smartstore.listener.OrderListClickListener
import com.ssafy.smartstore.model.OrderInfo
import com.ssafy.smartstore.util.ImageConverter
import com.ssafy.smartstore.util.WindowState.MYPAGE
import com.ssafy.smartstore.view.intro.IntroActivity
import com.ssafy.smartstore.viewmodel.OrderViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

private const val TAG = "MyPageFragment_싸피"

@RequiresApi(Build.VERSION_CODES.N)
class MyPageFragment : Fragment(), CoroutineScope, OrderListClickListener {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var binding: FragmentMyPageBinding
    private lateinit var adapter: OrderListAdapter
    private lateinit var userInfo: Map<String, Any>
//    private lateinit var orderRepo: OrderRepository
//    private lateinit var userRepo: UserRepository

    private lateinit var prefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private lateinit var orderInfoList: List<OrderInfo>

    private var user_id = ""
//    private var user_name = ""

    private val orderViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefs = requireActivity().getSharedPreferences("data", MODE_PRIVATE)
        editor = prefs.edit()
        user_id = prefs.getString("id", "") ?: ""


        initListView()

        observeDatas()

        initOrderList()

        getUserInfo()

        user_id?.let {
            orderViewModel.getOrderMonth(it)
        }
    }

    private fun observeDatas() {
        orderViewModel.responseUserInfo.observe(viewLifecycleOwner) {
            //통신 성공
            if (it.isSuccessful) {
                val response = it.body()

                response?.let {
                    userInfo = it
                    //todo 여기 로직 수정해야 리사이클러뷰 깜빡이는 것도 해결
                    initViews()

                }
            }
            //통신 실패
            else {
                val errerResponse = it.errorBody()
            }
        }
    }


    private fun logout() {
        editor.remove("id")
        editor.remove("name")
        editor.commit()
        startActivity(Intent(requireContext(), IntroActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    }

    private fun initViews() = with(binding) {
        tvName.text = (userInfo["user"] as Map<String, Any>)["name"] as String

        val limit = ((userInfo["grade"] as Map<String, Any>)["limit"] as Double).toInt()
        val grade = (userInfo["grade"] as Map<String, Any>)["title"] as String
        val img = (userInfo["grade"] as Map<String, Any>)["img"] as String

        if (grade.equals("커피나무")) {
            tvSeedLevelupInfo.text = "최고 단계 도달"
            tvSeedCount.text = "max"
            tvSeedInfo.text = "${grade}단계"

            progressBar.max = 1
            progressBar.progress = 1

        } else {
            val step = ((userInfo["grade"] as Map<String, Any>)["step"] as Double).toInt()
            val current = ((userInfo["grade"] as Map<String, Any>)["current"] as Double).toInt()
            val left = ((userInfo["grade"] as Map<String, Any>)["to"] as Double).toInt()

            tvSeedLevelupInfo.text = "다음 레벨까지 ${left}잔 남았습니다"
            tvSeedCount.text = "${current}/${limit}"
            tvSeedInfo.text = "${grade}${step} 단계"

            progressBar.max = limit
            progressBar.progress = current
        }

        ImageConverter.imageMap[img]?.let {
            ivGrade.setImageResource(it)
        }

        ivLogout.setOnClickListener {
            logout()
        }

    }

    //주문 리스트 데이터 초기화
    private fun getOrderInfoList() {
        orderInfoList = orderViewModel.orderInfoList.value!!
        //5개로 자르기(최근 주문 목록)
    }

    // 유저 정보 데이터 초기화
    private fun initOrderList() {
        launch {
            getOrderInfoList()
            Log.d(TAG, "initOrderList: 여기계속호출되니 ${orderInfoList}")
            adapter.submitList(orderInfoList)
        }
    }

    private fun getUserInfo() {
        launch {
            orderViewModel.getUserInfo(user_id)
        }
    }

    //뷰들 초기화
    private fun initListView() = with(binding) {

        // 주문 내역 리사이클러뷰 어댑터 연결
        adapter = OrderListAdapter(MYPAGE, this@MyPageFragment).apply {
//            setHasStableIds(true)

            rvOrderlist.adapter = this
            rvOrderlist.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

    }

    override fun onOrderListClickListener(orderInfo: OrderInfo) {
        val action = MyPageFragmentDirections.actionMyPageFragmentToOrderDetailFragment(orderInfo)
        findNavController().navigate(action)
    }

    override fun onOrderListCartClickListener(orderInfo: OrderInfo) {}
}