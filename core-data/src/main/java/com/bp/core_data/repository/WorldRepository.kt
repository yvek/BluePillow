package com.bp.core_data.repository

import com.bp.core_database.database.dao.WorldDao
import com.bp.core_network.network.apiResponse.ApiResponse
import com.bp.core_network.network.model.TestResponse
import com.bp.core_network.network.services.TestApiService
import javax.inject.Inject

class WorldRepository @Inject constructor() {

    @Inject
    lateinit var worldDao: WorldDao

    @Inject
    lateinit var testAPI: TestApiService
    suspend fun getWorlds():List<String>{
        return worldDao.getWorldsList()
    }

    suspend fun addWorld(world: String) {
        worldDao.insertWorld(world)
    }

    suspend fun fetchTestApiResponse(): ApiResponse<TestResponse> {
        return testAPI.getTestJson()
    }


}