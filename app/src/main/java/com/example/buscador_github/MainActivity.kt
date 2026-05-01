package com.example.buscador_github

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.buscador_github.iu.home.BucadorViewModel
import com.example.buscador_github.iu.home.Principal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val miviewModel: BucadorViewModel = viewModel()
            Principal(miviewModel)
        }
    }
}



