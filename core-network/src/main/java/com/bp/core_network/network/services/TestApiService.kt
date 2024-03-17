package com.bp.core_network.network.services

import com.bp.core_network.network.apiResponse.ApiResponse
import com.bp.core_network.network.model.TestResponse
import retrofit2.http.GET

interface TestApiService {

    @GET("todos/1")
    suspend fun getTestJson(): ApiResponse<TestResponse>
}