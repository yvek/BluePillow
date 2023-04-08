package com.mobile.bluepillow.data

import android.content.Context
import androidx.room.Room
import com.mobile.bluepillow.data.database.WorldDatabase

class WorldRepository {
     var context: Context
     private var db:WorldDatabase
    constructor(context: Context){
        this.context = context
        db = WorldDatabase.getInstance(context)!!
    }


    suspend fun getWorlds():List<String>{
        return db.getWorldDao().getWorldsList()
    }

    suspend fun addWorld(world: String) {
        db.getWorldDao().insertWorld(world)
    }


}