package com.example.kotlinretrofitip.Service

import com.example.kotlinretrofitip.Model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {
    // GET, POST, DELETE,
    //https://api.nomics.com/v1/prices?key=fc91e1c5714112bbfb7cf0b22d50649456db65d0
    @GET("prices?key=fc91e1c5714112bbfb7cf0b22d50649456db65d0")
    fun getData():Call<List<CryptoModel>>
}