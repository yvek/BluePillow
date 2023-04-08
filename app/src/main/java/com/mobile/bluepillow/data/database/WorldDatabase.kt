package com.mobile.bluepillow.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobile.bluepillow.data.database.dao.WorldDao
import com.mobile.bluepillow.data.database.entities.WorldEntity

@Database(entities = [WorldEntity::class],
version=1)
abstract class WorldDatabase : RoomDatabase() {
    companion object{
        private var instance:WorldDatabase? = null
        fun getInstance(context: Context):WorldDatabase?{
            if(instance == null){
                synchronized(WorldDatabase::class){
                    instance = Room.databaseBuilder(context,
                        WorldDatabase::class.java,"world_db")
                        .build()
                }
            }
            return instance

        }
    }
    abstract fun getWorldDao():WorldDao
}