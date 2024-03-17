package com.bp.core_network.network.services

import com.bp.core_network.network.model.TestResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface TestApiService {
    @GET("todos/1")
    suspend fun getTestJson(): ApiResponse<TestResponse>
}