package com.bp.core_network.network.di

import com.bp.core_network.network.config.Configuration
import com.bp.core_network.network.interceptor.OkHttpInterceptor
import com.bp.core_network.network.services.TestApiService
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{
    @Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofitInstance(okHttpClient: OkHttpClient):Retrofit{

        return Retrofit.Builder().client(okHttpClient)
            .baseUrl(Configuration.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTestAPIService(retrofit: Retrofit): TestApiService {
        return retrofit.create(TestApiService::class.java)
    }

}