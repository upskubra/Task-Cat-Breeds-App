package com.example.catbreeds.API

import com.example.catbreeds.model.CatModelItem
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder() {
    private val BASE_URL = "https://api.thecatapi.com/v1/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CatsAPI::class.java)

    fun getData(): Single<List<CatModelItem>> {
        return api.getCats()
    }


}