package com.ssafy.smartstore.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssafy.smartstore.dto.OrderInfo
import com.ssafy.smartstore.remote.dto.OrderInfoResponse
import com.ssafy.smartstore.remote.repository.OrderRepository
import com.ssafy.smartstore.remote.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class OrderViewModel: ViewModel() {
    private val _responseGetOrderMonth = MutableLiveData<Response<List<OrderInfoResponse>>>()
    private val _orderInfoList = MutableLiveData<List<OrderInfo>>()
//    private val _responseGetProduct = MutableLiveData<Response<List<MutableMap<String,Any>>>>()
    private val _responseUserInfo = MutableLiveData<Response<Map<String,Any>>>()

    val responseGetOrderMonth: LiveData<Response<List<OrderInfoResponse>>>
        get() = _responseGetOrderMonth

    val orderInfoList: LiveData<List<OrderInfo>>
        get() = _orderInfoList

    val responseUserInfo: LiveData<Response<Map<String,Any>>>
        get() = _responseUserInfo

    init {
        _orderInfoList.value = emptyList()
    }


    fun getOrderMonth(id: String) = viewModelScope.launch{
        _responseGetOrderMonth.value = OrderRepository.INSTANCE.getOrderMonth(id)
    }

    fun updateOrderInfoList(list: List<OrderInfo>){
        _orderInfoList.value = list
        Log.d("ababababa", "updateOrderInfoList: ${_orderInfoList.value}")
    }

    fun getUserInfo(id: String) = viewModelScope.launch{
        _responseUserInfo.value = UserRepository.INSTANCE.getInfo(id)
    }

//    fun getProduct(productId: Int) = viewModelScope.launch {
//        _responseGetProduct.value = ProductRepository.INSTANCE.getProduct(productId)
//    }
}