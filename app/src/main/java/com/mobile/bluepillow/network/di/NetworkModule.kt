package com.mobile.bluepillow.network.di

import com.mobile.bluepillow.config.Configuration
import com.mobile.bluepillow.network.interceptor.OkHttpInterceptor
import com.mobile.bluepillow.network.services.TestApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{
    @Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(OkHttpInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofitInstance(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder().client(okHttpClient)
            .baseUrl(Configuration.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTestAPIService(retrofit: Retrofit):TestApiService{
        return retrofit.create(TestApiService::class.java)
    }






}