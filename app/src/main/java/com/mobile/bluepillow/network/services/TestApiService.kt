package com.mobile.bluepillow.network.services

import com.mobile.bluepillow.network.apiResponse.ApiResponse
import com.mobile.bluepillow.network.model.TestResponse
import retrofit2.http.GET

interface TestApiService {

    @GET("todos/1")
    suspend fun getTestJson(): ApiResponse<TestResponse>
}