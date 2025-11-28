package com.example.app.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    const val baseUrl = "http://10.0.2.2:2000/api-webService/"

    private val retrofit by lazy {
        Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    fun buildUserService(): UserService = retrofit.create(UserService::class.java)
}

