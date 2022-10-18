package com.example.demo.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.api.RetrofitManager
import com.example.demo.util.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {
    //加载中
    val loadingLiveData = SingleLiveData<Boolean>()
    //异常
    val errorLiveData = SingleLiveData<Throwable>()

    fun launch(
        block: suspend () -> Unit,
        error: suspend (Throwable) -> Unit,
        complete: suspend () -> Unit
    ) {
        loadingLiveData.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                block()
            } catch (e: Exception) {
                Log.d("TAG", "launch: error ")
                error(e)
            } finally {
                complete()
            }
        }
    }
}

