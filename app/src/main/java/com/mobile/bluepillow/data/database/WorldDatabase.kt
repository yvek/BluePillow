package com.mobile.bluepillow.data.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobile.bluepillow.data.database.dao.WorldDao
import com.mobile.bluepillow.data.database.entities.WorldEntity
import javax.inject.Inject

@Database(entities = [WorldEntity::class],
version=1, exportSchema = true
)
abstract class WorldDatabase: RoomDatabase() {
    abstract fun getWorldDao():WorldDao
}