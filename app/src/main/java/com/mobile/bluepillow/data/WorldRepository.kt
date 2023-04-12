package com.mobile.bluepillow.data

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.mobile.bluepillow.data.database.WorldDatabase
import javax.inject.Inject

class WorldRepository @Inject constructor(){

    @Inject
    lateinit var db:WorldDatabase
    suspend fun getWorlds():List<String>{
        return db.getWorldDao().getWorldsList()
    }

    suspend fun addWorld(world: String) {
        db.getWorldDao().insertWorld(world)
    }


}