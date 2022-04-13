package com.example.catbreeds.API

import com.example.catbreeds.model.CatModel
import com.example.catbreeds.model.CatModelItem
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder() {
    private val BASE_URL = "https://api.thecatapi.com/v1/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(CatsAPI::class.java)

    fun getData() : Call<CatModel> {
        return api.getCats()
    }
}