package com.bp.core_network.network.apiResponse

import retrofit2.HttpException
import retrofit2.Response

sealed interface ApiResponse<T>

data class Success<T>(val data: T): ApiResponse<T>
data class Error<T>(val code:Int, val message:String?): ApiResponse<T>
data class Exception<T>(val exception: Throwable): ApiResponse<T>


suspend fun <T: Any> handleResponse(execute: suspend ()->Response<T>): ApiResponse<T>{

    return try {
        val response = execute()
        if (response.isSuccessful && response.body() != null) {
             Success(response.body()!!)
        } else {
             Error(response.code(), response.message())
        }
    }catch(e: HttpException){
        Error(e.code(),e.message())
    }catch (t: Throwable){
        Exception(t)
    }
}