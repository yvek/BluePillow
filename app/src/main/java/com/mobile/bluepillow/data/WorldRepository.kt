package com.mobile.bluepillow.data

import com.mobile.bluepillow.data.database.WorldDatabase
import com.mobile.bluepillow.network.apiResponse.ApiResponse
import com.mobile.bluepillow.network.model.TestResponse
import com.mobile.bluepillow.network.services.TestApiService
import retrofit2.Call
import javax.inject.Inject

class WorldRepository @Inject constructor(){

    @Inject
    lateinit var db:WorldDatabase

    @Inject
    lateinit var testAPI: TestApiService
    suspend fun getWorlds():List<String>{
        return db.getWorldDao().getWorldsList()
    }

    suspend fun addWorld(world: String) {
        db.getWorldDao().insertWorld(world)
    }

    suspend fun fetchTestApiResponse(): Call<ApiResponse<TestResponse>> {
        return testAPI.getTestJson()
    }


}