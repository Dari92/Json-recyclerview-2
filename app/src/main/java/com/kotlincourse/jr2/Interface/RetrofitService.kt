package com.kotlincourse.jr2.Interface

import com.kotlincourse.jr2.Model.Photos
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("getphotos")

    fun getPhotos() : Call<List<Photos>>
}