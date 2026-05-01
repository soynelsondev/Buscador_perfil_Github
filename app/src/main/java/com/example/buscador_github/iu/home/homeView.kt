@file:kotlin.OptIn(ExperimentalMaterial3Api::class)
package com.example.buscador_github.iu.home

import android.R.color.white
import androidx.annotation.OptIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.buscador_github.data.GithubUsers
import com.example.buscador_github.ui.theme.Fondo
import com.example.buscador_github.ui.theme.FondoCard
import com.example.buscador_github.ui.theme.icono
import com.example.buscador_github.R



@Composable
fun Principal(viewModel: BucadorViewModel){
    Scaffold (
        topBar = {toolbar()}
    )
    { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

            buscadorUser(viewModel)

        LazyColumn() {
            items(viewModel.listaUsuarios){
                usuario -> tarjetaUser(usuario = usuario)
            }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun toolbar(){
    TopAppBar(
        title = {Text("Buscador de Perfil GitHub")},
        colors = TopAppBarDefaults.topAppBarColors(Fondo, FondoCard)
    )

}

@Composable
fun buscadorUser(viewModel: BucadorViewModel){
    Row(modifier = Modifier.fillMaxWidth() .padding(10.dp) , verticalAlignment = Alignment.CenterVertically)
    {
        OutlinedTextField(
            value = viewModel.textoBusqueda,
            onValueChange = {viewModel.textBusqueda(it)},
            modifier = Modifier.weight(1f),
            placeholder = {Text("Buscar Usuario..")},
            shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = icono,
                unfocusedBorderColor = icono
            )
        )

        Button(onClick = {
            viewModel.realizarBusqueda()
        }, modifier = Modifier.height(56.dp),
            shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp),
            colors = ButtonDefaults.buttonColors(icono,FondoCard)
        ) { Icon(painter = painterResource(R.drawable.buscar), contentDescription = "lupa", tint = FondoCard) }

    }
}




@Composable
fun tarjetaUser(usuario: GithubUsers){

    val uriHandler = LocalUriHandler.current

    Card ( shape=RoundedCornerShape(12.dp) ,
            modifier = Modifier.fillMaxWidth() .height(130.dp),
        colors = CardDefaults.cardColors(containerColor = FondoCard)){

        Column(modifier = Modifier.fillMaxSize() .padding(4.dp) ) {

            Row {
                AsyncImage(
                    model = usuario.fotoPerfil,
                    contentDescription = "Foto perfil ${usuario.nombreUsuario}",
                    modifier = Modifier.size(80.dp)
                        .clip(CircleShape)
                )
                Text(text = usuario.nombreUsuario,
                    color = Fondo,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }

            TextButton(
                onClick = {if (usuario.urlPerfil.isNotEmpty()){
                    uriHandler.openUri(usuario.urlPerfil)
                }
                    },
                modifier = Modifier.padding(vertical = 10.dp)
            )
            { Text(text = "Ver Perfil", color = icono,fontWeight = FontWeight.Bold, fontSize = 18.sp)}
        }
    }
}