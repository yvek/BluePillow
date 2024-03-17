package com.mobile.bluepillow.network.services

import com.mobile.bluepillow.network.model.TestResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("todos/1")
    suspend fun getTestJson(): Response<TestResponse>

    @GET("todos/1")
    suspend fun getTestJsonv2(): ApiResponse<TestResponse>
}