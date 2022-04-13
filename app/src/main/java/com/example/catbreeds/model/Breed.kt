package com.example.catbreeds.model

data class Breed(
    val description: String,
    val dog_friendly: Int,
    val id: String,
    val life_span: String,
    val name: String,
    val origin: String,
    val reference_image_id: String,
    val temperament: String,
    val wikipedia_url: String
)