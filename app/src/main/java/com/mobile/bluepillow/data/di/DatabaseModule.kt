package com.mobile.bluepillow.data.di

import android.app.Application
import androidx.room.Room
import com.mobile.bluepillow.data.database.WorldDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun getAppDatabase(application: Application): WorldDatabase
    {
        return Room
            .databaseBuilder(application, WorldDatabase::class.java, "WorldDatabase.db")
            .fallbackToDestructiveMigration()
            .build()
        }
    }

