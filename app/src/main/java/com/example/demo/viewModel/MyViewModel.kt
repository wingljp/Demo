//package com.example.demo.viewModel
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.demo.api.BaseResult
//import com.example.demo.model.Photos
//import com.example.demo.repository.MyRepository
//import kotlinx.coroutines.launch
//
//class MyViewModel(private val myRepository: MyRepository) : ViewModel() {
//
//    public var myResponse: MutableLiveData<BaseResult<Photos>> = MutableLiveData()
//
//
//    fun getPosy() {
//        viewModelScope.launch {
//
//            val response = myRepository.getPost()
//
//             myResponse.value= response
//        }
//
//    }
//
//}