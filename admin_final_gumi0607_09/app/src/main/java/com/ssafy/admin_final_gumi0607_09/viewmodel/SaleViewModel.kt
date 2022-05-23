package com.ssafy.admin_final_gumi0607_09.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssafy.admin_final_gumi0607_09.data.remote.dto.Product
import com.ssafy.smartstore.data.remote.dto.OrderDetail
import com.ssafy.smartstore.data.remote.repository.OrderRepository
import com.ssafy.smartstore.data.remote.repository.ProductRepository
import com.ssafy.smartstore.data.remote.repository.UserRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class SaleViewModel : ViewModel() {

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

    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>>
        get() = _productList

    private val _orderDetailList = MutableLiveData<List<OrderDetail>>()
    val orderDetailList: LiveData<List<OrderDetail>>
        get() = _orderDetailList

    fun getProductList() = viewModelScope.launch {
        var response: Response<List<Product>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = ProductRepository.INSTANCE.getProductList()
        }
        job?.join()

        response?.let {
            it.body()?.let { result ->
                _productList.postValue(result)
            }
        }
    }

    fun getOrderDeatilList() = viewModelScope.launch {
        var response: Response<List<OrderDetail>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = OrderRepository.INSTANCE.getAllOrderDetail()
        }
        job?.join()

        response?.let {
            it.body()?.let { result ->
                _orderDetailList.postValue(result)
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