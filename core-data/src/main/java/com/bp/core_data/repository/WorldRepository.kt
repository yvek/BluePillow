package com.example.core_data.repository

import com.bp.core_network.network.apiResponse.ApiResponse
import com.bp.core_network.network.model.TestResponse
import com.bp.core_network.network.services.TestApiService
import javax.inject.Inject

class WorldRepository @Inject constructor() : IWorldRepository {

    @Inject
    lateinit var db:WorldDatabase

    @Inject
    lateinit var testAPI: TestApiService
    override suspend fun getWorlds():List<String>{
        return db.getWorldDao().getWorldsList()
    }

    override suspend fun addWorld(world: String) {
        db.getWorldDao().insertWorld(world)
    }

    override suspend fun fetchTestApiResponse(): ApiResponse<TestResponse> {
        return testAPI.getTestJson()
    }


}