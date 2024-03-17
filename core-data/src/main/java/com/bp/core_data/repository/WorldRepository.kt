package com.bp.core_data.repository

import androidx.annotation.WorkerThread
import com.bp.core_database.database.dao.WorldDao
import com.bp.core_network.network.config.Configuration
import com.bp.core_network.network.model.ErrorResponseMapper
import com.bp.core_network.network.services.TestApiService
import com.skydoves.sandwich.map
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class WorldRepository @Inject constructor() {

    @Inject
    lateinit var worldDao: WorldDao

    val homeUrl = Configuration.homeIconUrl

    @Inject
    lateinit var testAPI: TestApiService
    suspend fun getWorlds():List<String>{
        return worldDao.getWorldsList()
    }

    suspend fun addWorld(world: String) {
        worldDao.insertWorld(world)
    }

    @WorkerThread
    fun fetchTestApiResponse(
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?,String?) -> Unit
    )=
        flow{
            testAPI.getTestJson()
                .suspendOnSuccess {
                    emit(data)
                }
                .onError { map(ErrorResponseMapper) { onError("$message","$code") } }
                .onException { onError(message,"") }
        }.onStart { onStart() }
            .onCompletion { onComplete() }

}