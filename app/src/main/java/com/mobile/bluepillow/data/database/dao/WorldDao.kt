package com.mobile.bluepillow.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WorldDao {
    @Query("Select world from Worlds")
    suspend fun getWorldsList():List<String>

    @Query("Select world from Worlds where id = :id")
    suspend fun getWorldById(id:Int):String

    @Query("Insert into Worlds values (NULL, :world) ")
    suspend fun insertWorld(world:String)
}