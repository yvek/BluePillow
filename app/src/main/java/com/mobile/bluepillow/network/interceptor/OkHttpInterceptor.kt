package com.mobile.bluepillow.network.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

class OkHttpInterceptor: Interceptor {
    val TAG = "OkHttpInterceptor"
    override fun intercept(chain: Interceptor.Chain): Response {
        val request  = chain.request()
        Log.d(TAG, "intercept: "+ request.body)
        return chain.proceed(request)
    }
}