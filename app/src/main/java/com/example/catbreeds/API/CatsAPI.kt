package com.example.catbreeds.API

import com.example.catbreeds.model.CatModelItem
import io.reactivex.Single
import retrofit2.http.GET

interface CatsAPI {
    @GET("breeds")
    fun getCats(): Single<List<CatModelItem>>
}