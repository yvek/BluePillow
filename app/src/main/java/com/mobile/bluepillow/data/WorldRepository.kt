package com.mobile.bluepillow.data

import com.mobile.bluepillow.data.database.WorldDatabase
import com.mobile.bluepillow.network.model.ErrorResponseMapper
import com.mobile.bluepillow.network.model.TestResponse
import com.mobile.bluepillow.network.services.ApiService
import com.skydoves.sandwich.map
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import retrofit2.Response
import javax.inject.Inject

class WorldRepository @Inject constructor(){

    @Inject
    lateinit var worldDatabase:WorldDatabase

    @Inject
    lateinit var apiService: ApiService

    suspend fun getWorlds():List<String>{
        return worldDatabase.getWorldDao().getWorldsList()
    }

    suspend fun addWorld(world: String) {
        worldDatabase.getWorldDao().insertWorld(world)
    }

    suspend fun fetchTestApiResponse(): Response<TestResponse> {
        return apiService.getTestJson()
    }

    suspend fun fetchTestApiResponsev2(onStart: ()-> Unit,onComplete: () -> Unit, onError: (String?) -> Unit, )= flow {
        apiService.getTestJsonv2()
            .suspendOnSuccess {
                emit(data)
            }
            .onError { map(ErrorResponseMapper) { onError("[Code: $code]: $message") } }
            .onException { onError(message) }
    }.onStart { onStart }
    .onCompletion { onComplete }



}