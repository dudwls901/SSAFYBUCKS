package com.ssafy.smartstore.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.ssafy.smartstore.data.local.dto.Product
import com.ssafy.smartstore.data.remote.RetrofitClient
import com.ssafy.smartstore.data.remote.dto.Comment
import com.ssafy.smartstore.data.remote.repository.CommentRepository
import com.ssafy.smartstore.data.remote.repository.ProductRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

private const val TAG = "ProductViewModel"

class ProductViewModel : ViewModel() {

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

    // 제품 리스트
    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>>
        get() = _productList

    // 하나의 제품 정보
    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product>
        get() = _product

    // 해당 제품 코멘트 리스트
    private val _commentList = MutableLiveData<List<Comment>>()
    val commentList: LiveData<List<Comment>>
        get() = _commentList

    // 평점 숫자
    private val _ratingAvg = Transformations.map(_commentList) {
        var total = 0.0F
        it.forEach {
            total += it.rating
        }

        Math.round((total / 2 / it.size) * 10) / 10F
    }
    val ratingAvg: LiveData<Float>
        get() = _ratingAvg


    init {
        _productList.value = emptyList()
        _product.value = Product("", "", 0, "")
        _commentList.value = emptyList()
    }

    // 모든 제품 정보 호출
    fun getProductList() = viewModelScope.launch {
        _loading.postValue(true)
        var response: Response<List<Product>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = ProductRepository.INSTANCE.getProductList()
        }
        job?.join()

        response?.let {
            if (it.isSuccessful) {
                it.body()?.let { result ->
                    when (it.code()) {
                        200 -> {
                            _productList.postValue(result)
                            _loading.postValue(false)
                        }
                        else -> onError(it.message())
                    }
                }
            } else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }
    }

    // 제품 정보 세팅
    fun setProduct(product: Product) = viewModelScope.launch {
        _product.postValue(product)
    }

    // 코멘트 리스트 받아오기
    fun getCommentList(productId: Int) = viewModelScope.launch {
        _loading.postValue(true)
        var response: Response<List<Comment>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = CommentRepository.INSTANCE.searchComments(productId)
        }
        job?.join()

        response?.let {
            if (it.isSuccessful) {
                it.body()?.let { result ->
                    when (it.code()) {
                        200 -> {
                            _commentList.postValue(result)
                            _loading.postValue(false)
                        }
                        else -> onError(it.message())
                    }
                }
            } else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }
    }

    // 코멘트 등록
    fun insertComment(comment: Comment) = viewModelScope.launch {
        _loading.postValue(true)
        var response: Response<List<Comment>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = CommentRepository.INSTANCE.insertComment(comment)
        }
        job?.join()

        response?.let {
            if (it.isSuccessful) {
                it.body()?.let { result ->
                    _commentList.postValue(result)
                    _loading.postValue(false)
                }
            } else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }
    }

    // 코멘트 업데이트
    fun updateComment(comment: Comment) = viewModelScope.launch {
        _loading.postValue(true)
        var response: Response<List<Comment>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = CommentRepository.INSTANCE.updateComment(comment)
        }
        job?.join()

        response?.let {
            if (it.isSuccessful) {
                it.body()?.let { result ->
                    _commentList.postValue(result)
                    _loading.postValue(false)
                }
            } else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }
    }

    // 코멘트 삭제
    fun deleteComment(id: Int) = viewModelScope.launch {
        _loading.postValue(true)
        var response: Response<List<Comment>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = CommentRepository.INSTANCE.deleteComment(id)
        }
        job?.join()

        response?.let {
            if (it.isSuccessful) {
                it.body()?.let { result ->
                    _commentList.postValue(result)
                    _loading.postValue(false)
                }
            } else {
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
        _loading.value = false

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}