package com.ssafy.admin_final_gumi0607_09.viewmodel

import android.os.Build
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssafy.admin_final_gumi0607_09.data.remote.dto.Product
import com.ssafy.admin_final_gumi0607_09.model.OrderInfo
import com.ssafy.admin_final_gumi0607_09.model.OrderProduct
import com.ssafy.smartstore.data.remote.RetrofitClient
import com.ssafy.smartstore.data.remote.dto.OrderDetail
import com.ssafy.smartstore.data.remote.dto.OrderInfoResponse
import com.ssafy.smartstore.data.remote.repository.OrderRepository
import com.ssafy.smartstore.data.remote.repository.ProductRepository
import com.ssafy.smartstore.data.remote.repository.TokenRepository
import com.ssafy.smartstore.event.Event
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class OrderViewModel : ViewModel() {

    var job: Job? = null

    //코루틴 예외처리 핸들러
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    private var _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?>
    get() = _errorMessage

    private var _loading = MutableLiveData<Boolean>().apply {
        value = false
    }
    val loading: LiveData<Boolean>
    get() = _loading

    // 토스트 메시지 내용
    private val _toastMessage = MutableLiveData<Event<String>>()
    val toastMessage: LiveData<Event<String>> = _toastMessage

    private var _orderInfoResponse = MutableLiveData<List<OrderInfoResponse>>()
    val orderInfoResponse: LiveData<List<OrderInfoResponse>>
        get() = _orderInfoResponse

    private var _orderInfoList = MutableLiveData<List<OrderInfo>>()
    val orderInfoList: LiveData<List<OrderInfo>>
        get() = _orderInfoList

    private var _selectedDate = MutableLiveData<String>()
    val selectedDate: LiveData<String>
        get() = _selectedDate

    fun getOrderInfoResponse(date: String) = viewModelScope.launch{
        _loading.postValue(true)
        var response: Response<List<OrderInfoResponse>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = OrderRepository.INSTANCE.getOrderDay(date)
        }
        job?.join()
        response?.let {
            if(it.isSuccessful){
                it.body()?.let{ result->
                    when(it.code()){
                        200 -> {
                            _orderInfoList.postValue(changeOrderInfoList(result))
                            _loading.postValue(false)
                        }
                        else -> onError(it.message())
                    }
                }
            }else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }
    }

    fun changeOrderInfoList(orderInfoResponseList: List<OrderInfoResponse>): List<OrderInfo> {
        var orderInfoList = mutableListOf<OrderInfo>()
        val quantityMap = mutableMapOf<Int, MutableMap<Int, Int>>()

        //orderList가져오기
        var orderList = orderInfoResponseList
//        val productMap = mutableMapOf<Int, MutableMap<Int, Product>>()
        val productList = ArrayList<Pair<Int, Product>>()
        for (order in orderList) {
            if (quantityMap[order.o_id].isNullOrEmpty()) {
                quantityMap[order.o_id] = mutableMapOf()
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                quantityMap.getOrDefault(order.o_id, mutableMapOf()).apply {
                    this.put(
                        order.p_id,
                        this.getOrDefault(order.p_id, 0) + order.quantity
                    )
                }
            } else {
                quantityMap[order.o_id] ?: mutableMapOf<Int, Int>().apply {
                    this.put(
                        order.p_id,
                        this[order.p_id] ?: 0 + order.quantity
                    )
                }
            }

            val product = Product(
                order.p_id,
                order.p_name,
                order.type,
                order.price,
                order.img
            )
            productList.add(Pair(order.o_id, product))

        }
        orderList = orderList.distinctBy { it.o_id }

        for (order in orderList) {
            val orderProductList = ArrayList<OrderProduct>()
            productList.forEach {
                val (id, product) = it
                if (order.o_id == id) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        orderProductList.add(
                            OrderProduct(
                                quantity = quantityMap[order.o_id]!!.getOrDefault(product.id, 0)!!,
                                product = product
                            )
                        )
                    } else {
                        orderProductList.add(
                            OrderProduct(
                                quantity = quantityMap[order.o_id]!![product.id] ?: 0,
                                product = product
                            )
                        )
                    }
                }
            }
            orderInfoList.add(
                OrderInfo(
                    id = order.o_id,
                    date = order.order_time,
                    orderProductList = orderProductList,
                    user_name = order.user_name,
                    completed = order.completed,
                    user_id = order.user_id
                )
            )
        }
        return orderInfoList
    }

    fun changeOrderComplete(orderId: Int, userId: String, title: String, body: String) = viewModelScope.launch{
        _loading.postValue(true)
        var response: Response<String>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = OrderRepository.INSTANCE.changeOrderComplete(orderId)
        }
        job?.join()
        response?.let {
            if(it.isSuccessful){
                it.body()?.let{ result->
                    when(it.code()){
                        200 -> {
                            sendMessageTo(userId, title, body)
                            _loading.postValue(false)
                        }
                        else -> onError(it.message())
                    }
                }
            }else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }
    }

    private fun sendMessageTo(userId: String, title: String, body: String) = viewModelScope.launch{
        _loading.postValue(true)
        var response: Response<String>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = TokenRepository.INSTANCE.sendMessageTo(userId,title,body)
        }
        job?.join()
        response?.let {
            if(it.isSuccessful){
                it.body()?.let{ result->
                    when(it.code()){
                        200 -> {
                            _toastMessage.postValue(Event("음료(스낵) 제작 완료 메시지를 전송하였습니다."))
                            _loading.postValue(false)
                        }
                        else -> onError(it.message())
                    }
                }
            }else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }
    }


    private fun onError(message: String) {
        _errorMessage.value = message
        _loading.postValue(false)

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}