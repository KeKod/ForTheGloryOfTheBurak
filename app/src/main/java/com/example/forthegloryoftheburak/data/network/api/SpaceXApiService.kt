package com.example.forthegloryoftheburak.data.network.api

import com.example.forthegloryoftheburak.data.model.Rocket
import com.example.forthegloryoftheburak.data.model.Rocket2
import retrofit2.Response
import retrofit2.http.GET

interface SpaceXApiService {
    @GET("rockets")
    suspend fun getRockets(): List<Rocket>

    @GET("rockets")
    suspend fun getRockets2(): Response<List<Rocket2>>
}