package com.example.core_data.repository

import com.bp.core_network.network.apiResponse.ApiResponse
import com.bp.core_network.network.model.TestResponse

interface IWorldRepository {
    suspend fun getWorlds(): List<String>
    suspend fun addWorld(world: String)
    suspend fun fetchTestApiResponse(): ApiResponse<TestResponse>
}