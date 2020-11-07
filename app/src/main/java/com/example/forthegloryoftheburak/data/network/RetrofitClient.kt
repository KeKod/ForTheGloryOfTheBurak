package com.example.forthegloryoftheburak.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitClient {
    companion object {
        @Volatile
        private var INSTANCE: Retrofit? = null
        private val BASE_URL = "https://api.spacexdata.com/v3/"

        fun getRetrofit(): Retrofit {
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }.also {
                val okHttpClient = OkHttpClient.Builder().addInterceptor(it).build()
                return INSTANCE ?: run {
                    synchronized(this) {
                        Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(okHttpClient)
                            .baseUrl(BASE_URL)
                            .build()
                    }
                }
            }
        }
    }
}