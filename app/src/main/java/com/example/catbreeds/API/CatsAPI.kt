package com.example.catbreeds.API

import com.example.catbreeds.model.CatModel
import retrofit2.Call
import retrofit2.http.GET

interface CatsAPI {
    @GET("breeds")
    fun getCats(): Call<CatModel>
}