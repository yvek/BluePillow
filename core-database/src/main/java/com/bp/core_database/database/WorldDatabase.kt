package com.bp.core_database.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bp.core_database.database.dao.WorldDao
import com.bp.core_database.database.entities.WorldEntity
import javax.inject.Inject

@Database(entities = [WorldEntity::class],
version=1, exportSchema = true
)
abstract class WorldDatabase: RoomDatabase() {
    abstract fun getWorldDao(): WorldDao
}