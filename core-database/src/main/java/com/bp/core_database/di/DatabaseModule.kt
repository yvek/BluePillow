package com.bp.core_database.di

import android.app.Application
import androidx.room.Room
import com.bp.core_database.database.WorldDatabase
import com.bp.core_database.database.dao.WorldDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideBlogDao(
        database: WorldDatabase
    ): WorldDao = database.getWorldDao()

    @Provides
    @Singleton
    fun getAppDatabase(application: Application): WorldDatabase
    {
        return Room
            .databaseBuilder(application, WorldDatabase::class.java, "WorldDatabase.db")
            .fallbackToDestructiveMigration()
            .build()
        }
    }

