package com.example.forthegloryoftheburak.data.repository

import com.example.forthegloryoftheburak.data.model.Rocket
import com.example.forthegloryoftheburak.data.model.Rocket2
import com.example.forthegloryoftheburak.data.network.api.SpaceXApiService
import retrofit2.Response

class SpaceXRepository(private val apiService: SpaceXApiService) {
    suspend fun getRockets(): List<Rocket> {
        return apiService.getRockets()
    }

    suspend fun getRockets2(): Response<List<Rocket2>> {
        return apiService.getRockets2()
    }
}