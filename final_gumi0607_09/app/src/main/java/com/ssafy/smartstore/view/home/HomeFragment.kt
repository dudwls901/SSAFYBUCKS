package com.ssafy.smartstore.view.home

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.adapter.NotiAdapter
import com.ssafy.smartstore.adapter.OrderListAdapter
import com.ssafy.smartstore.data.local.dto.Noti
import com.ssafy.smartstore.data.local.repository.NotiRepository
import com.ssafy.smartstore.databinding.FragmentHomeBinding
import com.ssafy.smartstore.listener.NotiDeleteClickListener
import com.ssafy.smartstore.listener.OrderListClickListener
import com.ssafy.smartstore.data.remote.repository.ShoppingListRepository
import com.ssafy.smartstore.model.OrderInfo
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

    //todo fragment 백스택

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: $")
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
        Log.d(TAG, "onViewCreated: ")
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
        Log.d(TAG, "updateOrderList: 여기 계속 호출되니!!!!!!!!!!!!!${orderInfoList}")
        orderAdapter.submitList(orderInfoList.toMutableList())

    }

    private fun updateNotiList(list: List<Noti>) {
        Log.d(TAG, "onCreateView: noti change ${list.joinToString()}")
        list.forEach {
            Log.d(TAG, "updateNotiList: ${it.id} ${it.u_id} ${it.data}")
        }
        notiAdapter.submitList(list.toMutableList())
    }

    //listener

    override fun onOrderListClickListener(orderInfo: OrderInfo) {
        val action = HomeFragmentDirections.actionHomeFragmentToOrderDetailFragment(orderInfo)
        findNavController().navigate(action)
    }

    // 장바구니 버튼
    override fun onOrderListCartClickListener(orderInfo: OrderInfo) {
        orderViewModel.addItem(orderInfo, userId, "list")
        var sumQuantity = 0
        for (orderProduct in orderInfo.orderProductList) {
            sumQuantity += orderProduct.quantity
        }
        val orderText = if (sumQuantity == 1) {
            "${orderInfo.orderProductList[0].product.name} ${sumQuantity}잔"
        } else {
            "${orderInfo.orderProductList[0].product.name}외 ${sumQuantity - 1}잔"
        }
        Toast.makeText(
            requireContext(),
            "${orderText}을 장바구니에 담았습니다",
            Toast.LENGTH_SHORT
        ).show()
        val action = HomeFragmentDirections.actionHomeFragmentToShoppingListFragment()
        findNavController().navigate(action)
    }

    override fun onNotiDeleteClickListener(idx: Int) {
        launch {
            withContext(Dispatchers.Main) {
                notiRepo.delete(idx)
            }
            val notiList = notiRepo.select(userId)
            Log.d(TAG, "onNotiDeleteClickListener:$idx ${notiList}")
            homeViewModel.updateNotiList(notiList)
        }
    }
}