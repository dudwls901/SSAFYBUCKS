package com.ssafy.admin_final_gumi0607_09.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ssafy.admin_final_gumi0607_09.R
import com.ssafy.admin_final_gumi0607_09.data.remote.dto.Product
import com.ssafy.admin_final_gumi0607_09.databinding.FragmentOrderBinding
import com.ssafy.admin_final_gumi0607_09.model.OrderInfo
import com.ssafy.admin_final_gumi0607_09.model.OrderProduct
import com.ssafy.admin_final_gumi0607_09.viewmodel.OrderViewModel

class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private lateinit var adapter: OrderAdapter
    private val orderViewModel: OrderViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeDatas()
        getDatas()
    }
    private fun observeDatas(){
        orderViewModel.orderInfoList.observe(viewLifecycleOwner){
            Log.d(TAG, "observeDatas: $it")
            updateListView(it)
        }
    }

    private fun getDatas(){
        orderViewModel.getOrderInfoResponse("20220523")
    }

    private fun initViews() = with(binding){
        adapter = OrderAdapter{ isExpanded, position ->
            when(isExpanded){

            }
        }
        orderRv.adapter = adapter
    }

    private fun updateListView(list: List<OrderInfo>){
        adapter.submitList(list)
    }

    companion object {
        const val TAG = "OrderFragment_sss"
    }
}