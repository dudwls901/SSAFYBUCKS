package com.ssafy.admin_final_gumi0607_09.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssafy.smartstore.data.remote.repository.UserRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.*
import kotlin.collections.HashMap

class UserViewModel : ViewModel() {

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

    private val _userList = MutableLiveData<List<HashMap<String, Any>>>()
    val userList: LiveData<List<HashMap<String, Any>>>
        get() = _userList

    fun getUserList() = viewModelScope.launch {
        var response: Response<List<HashMap<String, Any>>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = UserRepository.INSTANCE.getInfos()
        }
        job?.join()

        response?.let {
            it.body()?.let { result ->
                _userList.postValue(result)
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