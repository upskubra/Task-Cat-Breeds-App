package com.example.catbreeds.model

data class CatModel(
    val breeds: List<Breed>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)