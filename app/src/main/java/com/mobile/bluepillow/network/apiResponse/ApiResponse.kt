package com.mobile.bluepillow.network.apiResponse

import retrofit2.Response

sealed interface ApiResponse<T>

data class Success<T>(val data: T):ApiResponse<T>
data class Error<T>(val code:Int, val message:String?):ApiResponse<T>
data class Exception<T>(val exception: Throwable):ApiResponse<T>


suspend fun handleRetrofitResponse(execute: suspend ()->Response<T>){

    val response = execute()
    val body = response.body()
    if(response.isSuccessful && )
}