package com.example.buscador_github.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    private const val BaseUrl ="https://api.github.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiBuscador = retrofit.create(ApiBuscador::class.java)

}