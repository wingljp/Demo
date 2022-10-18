package com.example.demo

import androidx.lifecycle.ViewModelProvider
import com.example.demo.repository.MyRepository


abstract class MainViewModelFactory (private val repository: MyRepository):ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return NewsViewModel(repository) as T
//    }
}