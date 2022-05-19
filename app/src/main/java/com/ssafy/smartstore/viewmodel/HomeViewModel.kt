package com.ssafy.smartstore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ssafy.smartstore.data.local.dto.Noti

class HomeViewModel: ViewModel() {
    private val _notiList = MutableLiveData<List<Noti>>()

    val notiList: LiveData<List<Noti>>
        get() = _notiList

    init {
//        _notiList.value = ArrayList()
    }


    fun updateNotiList(list: List<Noti>){
        _notiList.value = list
    }
}