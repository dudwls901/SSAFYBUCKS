package com.ssafy.admin_final_gumi0607_09.view

import android.R.attr.y
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ssafy.admin_final_gumi0607_09.databinding.FragmentOrderBinding
import com.ssafy.admin_final_gumi0607_09.model.OrderInfo
import com.ssafy.admin_final_gumi0607_09.viewmodel.OrderViewModel
import com.ssafy.smartstore.event.EventObserver


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
        binding = FragmentOrderBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeDatas()
        getDatas(orderViewModel.selectedDate.value!!)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun observeDatas() {
        orderViewModel.orderInfoList.observe(viewLifecycleOwner) {
            updateListView(it)
        }
        orderViewModel.toastMessage.observe(viewLifecycleOwner, EventObserver {
            if (it.isNotEmpty()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                orderViewModel.getOrderInfoResponse(orderViewModel.selectedDate.value!!)
            }
        })

        orderViewModel.selectedDate.observe(viewLifecycleOwner){
            getDatas(it)
        }
    }

    private fun getDatas(date: String) {
        Log.d(TAG, "getDatas: $date")
        orderViewModel.getOrderInfoResponse(date)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initViews() = with(binding) {
        binding.vm = orderViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        adapter = OrderAdapter { orderId, userId, title, body ->
            orderViewModel.changeOrderComplete(orderId, userId, title, body)
        }
        orderRv.adapter = adapter

        orderIbRight.setOnClickListener {
            orderViewModel.changeSelectedDate("up")
        }
        orderIbLeft.setOnClickListener {
            orderViewModel.changeSelectedDate("down")
        }
        orderTvDate.setOnClickListener {
            showDate()
        }
    }

    private fun updateListView(list: List<OrderInfo>) {
        adapter.submitList(list)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun showDate() {
        var (y,m,d) = orderViewModel.selectedDate.value!!.split('.').map{it.toInt()}
        Log.d(TAG, "showDate $y $m $d")
        val datePickerDialog = DatePickerDialog(requireContext(),
            OnDateSetListener { view, year, month, dayOfMonth ->
                Log.d(TAG, "showDate: ${year} $month $dayOfMonth")

                val ymd = (year%100).toString()+"." +(month+1).toString()+"."+dayOfMonth.toString()
                orderViewModel.changeSelectedDate(ymd)
                Log.d(TAG, "showDate $ymd")
            }, y+2000, m-1, d
        )
        datePickerDialog.setMessage("날짜 선택")
        datePickerDialog.show()
    }

    companion object {
        const val TAG = "OrderFragment_sss"
    }
}