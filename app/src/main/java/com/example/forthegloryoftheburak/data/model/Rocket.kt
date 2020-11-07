package com.example.forthegloryoftheburak.data.model

import com.google.gson.annotations.SerializedName

data class Rocket(
    val id: Int,
    @SerializedName("rocket_name")
    val name: String
)