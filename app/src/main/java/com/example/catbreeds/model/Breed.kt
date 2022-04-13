package com.example.catbreeds.model

import com.google.gson.annotations.SerializedName

data class Breed(
    @SerializedName("description")
    val description: String,
    @SerializedName("dog_friendly")
    val dog_friendly: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("life_span")
    val life_span: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("reference_image_id")
    val reference_image_id: String,
    @SerializedName("temperament")
    val temperament: String,
    @SerializedName("wikipedia_url")
    val wikipedia_url: String
)