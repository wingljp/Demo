package com.example.demo.repository

sealed class ResState<out T : Any> {
    data class Success<out T : Any>(val data: Any?) : ResState<T>()
    data class Error(val exception: Exception) : ResState<Nothing>()
}
