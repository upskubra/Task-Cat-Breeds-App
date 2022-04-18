package com.example.catbreeds.model


import com.google.gson.annotations.SerializedName

data class İmage(
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("width")
    val width: Int
)