package com.example.buscador_github.data

import com.google.gson.annotations.SerializedName


data class GithubUsers(
    @SerializedName("login")
    val nombreUsuario : String,

    @SerializedName("avatar_url")
    val fotoPerfil : String,

    @SerializedName("html_url")
     val urlPerfil : String


)

data  class BuscarResponse(
    @SerializedName("items")
    val listaUsuarios: List<GithubUsers>
)