package com.ssafy.smartstore.view.home

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.adapter.NotiAdapter
import com.ssafy.smartstore.adapter.OrderListAdapter
import com.ssafy.smartstore.data.local.dto.Noti
import com.ssafy.smartstore.databinding.FragmentHomeBinding
import com.ssafy.smartstore.model.OrderInfo
import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.listener.NotiDeleteClickListener
import com.ssafy.smartstore.listener.OrderListClickListener
import com.ssafy.smartstore.data.local.dto.Product
import com.ssafy.smartstore.data.local.repository.NotiRepository
import com.ssafy.smartstore.data.remote.dto.OrderInfoResponse
import com.ssafy.smartstore.util.WindowState.HOME
import com.ssafy.smartstore.viewmodel.HomeViewModel
import com.ssafy.smartstore.viewmodel.OrderViewModel
import kotlinx.coroutines.*


private const val TAG = "HomeFragment_싸피"

@RequiresApi(Build.VERSION_CODES.N)
class HomeFragment : Fragment(), CoroutineScope, OrderListClickListener, NotiDeleteClickListener {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var userId: String
    private lateinit var userName: String
    private lateinit var binding: FragmentHomeBinding
    private lateinit var orderAdapter: OrderListAdapter
    private lateinit var notiAdapter: NotiAdapter

    private lateinit var notiRepo: NotiRepository

    private val homeViewModel: HomeViewModel by activityViewModels()
    private val orderViewModel: OrderViewModel by activityViewModels()


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val prefs = requireActivity().getSharedPreferences("data", Context.MODE_PRIVATE)
        userId = prefs.getString("id", "") ?: ""
        userName = prefs.getString("name", "") ?: ""

        notiAdapter = NotiAdapter(this@HomeFragment)

        notiRepo = NotiRepository.getInstance(requireContext())

        observeDatas()
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeVM = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        userId?.let {
            orderViewModel.getOrderMonth(it)
            launch {
                val notiList = notiRepo.select(userId)
                homeViewModel.updateNotiList(notiList)
            }
        }
        initViews()
    }

    private fun observeDatas() {
        orderViewModel.orderInfoList.observe(viewLifecycleOwner) {
            updateOrderList(it)
        }
        Log.d(TAG, "onViewCreated: noti ${userId}")
        homeViewModel.notiList.observe(viewLifecycleOwner) {
            updateNotiList(it)
        }


    }

    private suspend fun getNotiList() {
        homeViewModel.updateNotiList(notiRepo.select(userId))
    }


    //뷰들 초기화
    private fun initViews() = with(binding) {

        tvHeaderName.text = userName

        // 최근주문 리사이클러뷰 어댑터 연결
        orderAdapter = OrderListAdapter(
            HOME,
            this@HomeFragment
        ).apply {
            setHasStableIds(true)

            rvRecentOrder.adapter = this
            rvRecentOrder.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        // 알림판 리사이클러뷰 어댑터 연결
        notiAdapter = NotiAdapter(this@HomeFragment).apply {
            rvNoti.adapter = this
            rvNoti.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

    }

    //주문 리스트 데이터 업데이트
    private fun updateOrderList(orderInfoList: List<OrderInfo>) {
        //어댑터 갱신
        orderAdapter.submitList(orderInfoList)
        binding.rvRecentOrder.adapter = orderAdapter

    }

    private fun updateNotiList(list: List<Noti>) {
        Log.d(TAG, "onCreateView: noti change ${list.joinToString()}")
        notiAdapter.submitList(list)
        notiAdapter.notifyDataSetChanged()
    }

    //listener

    override fun onOrderListClickListener(orderInfo: OrderInfo) {
        val bundle = Bundle()
        bundle.putParcelable("orderInfo", orderInfo)
        val intent = Intent(requireContext(), OrderDetailActivity::class.java)
        intent.putExtra("orderInfo", bundle)
        startActivity(intent)
    }

    override fun onOrderListCartClickListener(orderInfo: OrderInfo) {
        val intent = Intent(requireContext(), ShoppingListActivity::class.java)
        intent.putExtra("orderInfo", orderInfo)
        startActivity(intent)
    }

    override fun onNotiDeleteClickListener(idx: Int) {
        launch {
            withContext(Dispatchers.Main) {
                notiRepo.delete(id)
            }
            val notiList = notiRepo.select(userId)
            homeViewModel.updateNotiList(notiList)
        }
    }
}