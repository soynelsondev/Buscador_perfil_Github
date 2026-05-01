package com.example.buscador_github.iu.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscador_github.data.GithubUsers
import com.example.buscador_github.data.RetrofitClient
import kotlinx.coroutines.launch

class BucadorViewModel : ViewModel(){

    var listaUsuarios by mutableStateOf<List<GithubUsers>>(emptyList())
    var textoBusqueda by mutableStateOf("")
        private set

    fun textBusqueda(nuevoTexto : String){
        textoBusqueda = nuevoTexto
    }


    fun realizarBusqueda(){
        viewModelScope.launch {
        try {
            val respuesta = RetrofitClient.apiService.buscarUsuarios(textoBusqueda)

            listaUsuarios = respuesta.body()?.listaUsuarios ?: emptyList()

        }catch (e: Exception){
            listaUsuarios = emptyList()
        }
        }
    }
}