package com.example.forthegloryoftheburak.di

import com.example.forthegloryoftheburak.data.network.RetrofitClient
import com.example.forthegloryoftheburak.data.network.api.SpaceXApiService
import com.example.forthegloryoftheburak.data.repository.SpaceXRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single { provideRetrofit() }

    single { provideSpaceXApiService(get()) }
    single { SpaceXRepository(get()) }
}

fun provideRetrofit(): Retrofit = RetrofitClient.getRetrofit()

fun provideSpaceXApiService(
    retrofit: Retrofit
): SpaceXApiService = retrofit.create(SpaceXApiService::class.java)