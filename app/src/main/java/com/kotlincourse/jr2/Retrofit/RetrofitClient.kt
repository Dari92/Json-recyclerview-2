package com.kotlincourse.jr2.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var retrofit : Retrofit? = null

    fun getPhotos(urlBase: String) : Retrofit {
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}