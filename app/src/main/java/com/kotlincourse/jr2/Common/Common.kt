package com.kotlincourse.jr2.Common

import com.kotlincourse.jr2.Interface.RetrofitService
import com.kotlincourse.jr2.Retrofit.RetrofitClient

object Common {

    private val  BASE_URL= "https://2f56fd02-93f1-4033-a3e9-224277044942.mock.pstmn.io/"

            val retrofitService
            get() = RetrofitClient.getPhotos(BASE_URL).create(RetrofitService::class.java)
}