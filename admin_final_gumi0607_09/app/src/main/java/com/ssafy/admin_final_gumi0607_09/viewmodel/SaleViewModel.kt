package com.ssafy.admin_final_gumi0607_09.viewmodel

import android.util.Log
import androidx.collection.arrayMapOf
import androidx.lifecycle.*
import com.ssafy.admin_final_gumi0607_09.data.remote.dto.Product
import com.ssafy.admin_final_gumi0607_09.data.remote.repository.CommentRepository
import com.ssafy.smartstore.data.remote.dto.Comment
import com.ssafy.smartstore.data.remote.dto.OrderDetail
import com.ssafy.smartstore.data.remote.repository.OrderRepository
import com.ssafy.smartstore.data.remote.repository.ProductRepository
import com.ssafy.smartstore.data.remote.repository.UserRepository
import kotlinx.coroutines.*
import retrofit2.Response
import java.util.*

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

    private val _orderDetailList =
        MutableLiveData<List<OrderDetail>>()
    val orderDetailList: LiveData<List<OrderDetail>>
        get() = _orderDetailList

    private val _commenttList = MutableLiveData<List<Comment>>()
    val commenttList: LiveData<List<Comment>>
        get() = _commenttList

    // 제품별 판매량
    private val _productQuantity =
        MutableLiveData<MutableMap<String, Int>>()
    val productQuantity: LiveData<MutableMap<String, Int>>
        get() = _productQuantity

    // 제품 중 최고 판매량
    private val _highQuantity = Transformations.map(_productQuantity) {
        Collections.max(it.values)
    }
    val highQuantity: LiveData<Int>
        get() = _highQuantity

    // 제품별 매출
    private val _productSales =
        MutableLiveData<MutableMap<String, Int>>()
    val productSales: LiveData<MutableMap<String, Int>>
        get() = _productSales

    fun getProductANDDeatilList() = viewModelScope.launch {
        var response: Response<List<Product>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = ProductRepository.INSTANCE.getProductList()
        }
        job?.join()

        response?.let {
            it.body()?.let { result ->
                _productList.postValue(result)
                Log.d("TAG", "getProductList: $result")
            }
        }

        var response2: Response<List<OrderDetail>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response2 = OrderRepository.INSTANCE.getAllOrderDetail()
        }
        job?.join()

        response2?.let {
            it.body()?.let { result ->
                _orderDetailList.postValue(result)
                Log.d("TAG", "getProductList: $result")
            }
        }
    }

    fun getCommentList() = viewModelScope.launch {
        var response: Response<List<Comment>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = CommentRepository.INSTANCE.selectAll()
        }
        job?.join()

        response?.let {
            it.body()?.let { result ->
                _commenttList.postValue(result)
            }
        }
    }

    fun getProductQuantityANDSales() {
        val result = mutableMapOf<String, Int>()
        val result2 = mutableMapOf<String, Int>()

        for (item in _productList.value!!) {
            val price = item.price
            val productId = item.id
            var total = 0
            var totalsales = 0
            _orderDetailList.value!!.filter {
                it.productId == productId
            }.forEach {
                total += it.quantity
                totalsales += it.quantity * price
            }
            result.put("$productId", total)
            result2.put("$productId", totalsales)
        }
        _productQuantity.value = result
        _productSales.value = result2
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