package com.example.buscador_github.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiBuscador {

    @GET("search/users")
    suspend fun buscarUsuarios(
        @Query("q") textBuscar : String
    ): Response<BuscarResponse>
}