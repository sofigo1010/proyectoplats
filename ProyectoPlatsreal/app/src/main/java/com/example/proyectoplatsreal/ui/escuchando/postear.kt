package com.example.proyectoplatsreal.ui.escuchando

import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoplatsreal.R
import com.example.proyectoplatsreal.ui.theme.darkbackground
import com.example.proyectoplatsreal.ui.theme.darkbase
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PublishSongScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkbackground) // Asegúrate de que este color esté definido en tu archivo de colores
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Escuchando",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.logo), // Reemplaza con tu recurso de logo
                    contentDescription = "Logo",
                    modifier = Modifier.size(50.dp) // Ajusta el tamaño según necesites
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = "", // Enlazar a un estado
                onValueChange = { /* Actualizar estado */ },
                label = { Text("Nombre de la canción", color = Color.White) },
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = "", // Enlazar a un estado
                onValueChange = { /* Actualizar estado */ },
                label = { Text("Artista de la canción", color = Color.White) },
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    // Acción para publicar
                },
                colors = ButtonDefaults.buttonColors(darkbase),
                modifier = Modifier.align(Alignment.CenterHorizontally) // Alinea el botón al centro
            ) {
                Text("Publicar")
            }
        }
    }
}

