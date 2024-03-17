package com.bp.core_network.network.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

class OkHttpInterceptor: Interceptor {
    val TAG = "NetworkInterceptor"
    override fun intercept(chain: Interceptor.Chain): Response {
        val request  = chain.request()
        Log.d(TAG, request.body().toString())
        return chain.proceed(request)
    }
}