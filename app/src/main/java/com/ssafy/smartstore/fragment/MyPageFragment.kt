package com.ssafy.smartstore.fragment

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.LoginActivity
import com.ssafy.smartstore.OrderDetailActivity
import com.ssafy.smartstore.adapter.OrderListAdapter
import com.ssafy.smartstore.databinding.FragmentMyPageBinding
import com.ssafy.smartstore.dto.OrderInfo
import com.ssafy.smartstore.global.windowState
import com.ssafy.smartstore.listener.OrderListClickListener
import com.ssafy.smartstore.util.ImageConverter
import com.ssafy.smartstore.viewmodel.OrderViewModel
import kotlinx.coroutines.*

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

//        userRepo = UserRepository.getInstance(requireContext())
//        orderRepo = OrderRepository.getInstance(requireContext())
        prefs = requireActivity().getSharedPreferences("data", MODE_PRIVATE)
        editor = prefs.edit()
        user_id = prefs.getString("id", "") ?: ""
//        user_name = prefs.getString("name", "") ?: ""


//        Log.d(TAG, "onViewCreated: ${user_id}")

        observeDatas()

        initOrderList()

        getUserInfo()


    }

    private fun observeDatas() {
        orderViewModel.responseUserInfo.observe(viewLifecycleOwner) {
            //통신 성공
            if (it.isSuccessful) {
                val response = it.body()

                response?.let {
                    userInfo = it
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
        startActivity(Intent(requireContext(), LoginActivity::class.java).apply {
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
        launch() {
            getOrderInfoList()
            initListView()
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
        adapter = OrderListAdapter(windowState.MYPAGE, this@MyPageFragment).apply {
            setHasStableIds(true)
            submitList(orderInfoList)

            rvOrderlist.adapter = this
            rvOrderlist.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        // 유정 정보 세팅
//        tvName.text = user_name

        // 스탬프 세팅
//        val result = calStamp()
//        val grade = result["grade"] as String
//        val left = result["left"] as Int
//        val limit = result["limit"] as Int
//        val img = result["img"] as String

//        tvSeedInfo.text = "${grade}단계"
//
//        if (grade.equals("나무")) {
//            tvSeedLevelupInfo.text = "최고 단계 도달"
//            tvSeedCount.text = "max"
//
//            progressBar.max = 1
//            progressBar.progress = 1
//
//        } else {
//            tvSeedLevelupInfo.text = "다음 레벨까지 ${left}잔 남았습니다"
//            tvSeedCount.text = "${limit - left}/${limit}"
//
//            progressBar.max = limit
//            progressBar.progress = limit - left
//        }
//
//        ImageConverter.imageMap[img]?.let {
//            ivGrade.setImageResource(it)
//        }
    }

    // 스탬프 계산하는 함수
//    fun calStamp(): Map<String, Any> {
//        var total = data["stamp"] as Int
//        var grade = ""
//        var left = 0
//        var limit = 0
//        var img = ""
//        if (total < 50) {
//            val arr = arrayListOf<String>("씨앗1", "씨앗2", "씨앗3", "씨앗4", "씨앗5")
//            val num: Int = total / 10
//            grade = arr[num]
//            left = 10 - total % 10
//            limit = 10
//            img = "seeds.png"
//
//        } else if (total < 125) {
//            val arr = arrayListOf<String>("꽃1", "꽃2", "꽃3", "꽃4", "꽃5")
//            val num: Int = (total - 50) / 15
//            grade = arr[num]
//            left = 15 - (total - 50) % 15
//            limit = 15
//            img = "flower.png"
//
//        } else if (total < 225) {
//            val arr = arrayListOf<String>("열매1", "열매2", "열매3", "열매4", "열매5")
//            val num: Int = (total - 125) / 20
//            grade = arr[num]
//            left = 20 - (total - 125) % 20
//            limit = 20
//            img = "fruit.png"
//
//        } else if (total < 350) {
//            val arr = arrayListOf<String>("커피콩1", "커피콩2", "커피콩3", "커피콩4", "커피콩5")
//            val num: Int = (total - 225) / 25
//            grade = arr[num]
//            left = 25 - (total - 225) % 25
//            limit = 25
//            img = "beans.png"
//
//        } else {
//            grade = "나무"
//            img = "tree.png"
//
//        }
//
//        val map: MutableMap<String, Any> = HashMap()
//        map["grade"] = grade
//        map["left"] = left
//        map["limit"] = limit
//        map["img"] = img
//        return map
//    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyPageFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onOrderListClickListener(orderInfo: OrderInfo) {
        val intent = Intent(requireContext(), OrderDetailActivity::class.java)
        intent.putExtra("orderInfo", orderInfo)
        startActivity(intent)
    }

    override fun onOrderListCartClickListener(orderInfo: OrderInfo) {}
}