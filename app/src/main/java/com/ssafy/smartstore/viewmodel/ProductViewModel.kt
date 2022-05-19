package com.ssafy.smartstore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssafy.smartstore.data.local.dto.Product
import com.ssafy.smartstore.data.remote.dto.Comment
import com.ssafy.smartstore.data.remote.repository.CommentRepository
import com.ssafy.smartstore.data.remote.repository.ProductRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ProductViewModel: ViewModel() {
    private val _responseGetProductList = MutableLiveData<Response<List<Product>>>()

    private val _responseGetProduct = MutableLiveData<Response<Product>>()

    private val _responseGetCommentList = MutableLiveData<Response<List<Comment>>>()

    val responseGetProductList: LiveData<Response<List<Product>>>
        get() = _responseGetProductList

    val responseGetProduct: LiveData<Response<Product>>
        get() = _responseGetProduct

    val responseGetCommentList: LiveData<Response<List<Comment>>>
        get() = _responseGetCommentList

    fun getProductList() = viewModelScope.launch{
        _responseGetProductList.value = ProductRepository.INSTANCE.getProductList()
    }

    fun getProduct(productId: Int) = viewModelScope.launch {
        _responseGetProduct.value = ProductRepository.INSTANCE.getProduct(productId)
    }

    fun getCommentList(productId: Int) = viewModelScope.launch{
        _responseGetCommentList.value = CommentRepository.INSTANCE.searchComments(productId)
    }

    fun insertComment(comment: Comment) = viewModelScope.launch{
        _responseGetCommentList.value = CommentRepository.INSTANCE.insertComment(comment)
    }

    fun updateComment(comment: Comment) = viewModelScope.launch{
        _responseGetCommentList.value = CommentRepository.INSTANCE.updateComment(comment)
    }

    fun deleteComment(id: Int) = viewModelScope.launch{
        _responseGetCommentList.value = CommentRepository.INSTANCE.deleteComment(id)
    }
}