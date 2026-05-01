package com.example.buscador_github.iu.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buscador_github.ui.theme.FondoCard


@Composable
fun Principal(viewModel: BucadorViewModel){

}


@Preview(showSystemUi = true)
@Composable
fun tarjetaUser(){

    Card ( shape=RoundedCornerShape(12.dp) ,
            modifier = Modifier.fillMaxWidth() .height(130.dp),
        colors = CardDefaults.cardColors(containerColor = FondoCard)){

        Column(modifier = Modifier.fillMaxSize() .padding(4.dp) ) {

        }
    }
}