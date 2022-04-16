package com.example.catbreeds.model

import com.google.gson.annotations.SerializedName

data class CatModelItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("dog_friendly")
    val dogFriendly: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: İmage,
    @SerializedName("life_span")
    val lifeSpan: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("reference_image_id")
    val referenceİmageİd: String,
    @SerializedName("temperament")
    val temperament: String,
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String
)