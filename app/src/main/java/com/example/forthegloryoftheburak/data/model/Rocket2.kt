package com.example.forthegloryoftheburak.data.model

import com.google.gson.annotations.SerializedName

data class Rocket2(
    val id: Int,
    @SerializedName("rocket_name")
    val name: String
)