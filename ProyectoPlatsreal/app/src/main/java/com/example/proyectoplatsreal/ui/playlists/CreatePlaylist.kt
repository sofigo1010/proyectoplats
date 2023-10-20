package com.example.proyectoplatsreal.ui.playlists

import android.media.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoplatsreal.R
import com.example.proyectoplatsreal.ui.theme.darkbackground
import com.example.proyectoplatsreal.ui.theme.darkbase

@Composable
fun PlaylistsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkbackground) // Color de fondo basado en la imagen
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Row que contendrá el título y el logo
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Título "Playlists"
                Text(
                    text = "Playlists",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                // Logo a la derecha
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(50.dp)  // Puedes ajustar el tamaño según lo necesites
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Cada sección de filtro: Género, Idioma, Artista
            listOf("Género", "Idioma", "Artista").forEach { title ->
                FilterSection(title = title)
                Spacer(modifier = Modifier.height(20.dp))
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Botón "Generar"
            Button(
                onClick = { /* Acción para generar */ },
                colors = ButtonDefaults.buttonColors(darkbase) // Color basado en la imagen
                ,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Generar", color = Color.White)
            }

            Spacer(modifier = Modifier.height(40.dp))

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSection(title: String) {
    Column {
        // Título: Género, Idioma, Artista
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // TextField
        OutlinedTextField(
            value = "", // Enlazar a un estado
            onValueChange = { /* Actualizar estado */ },
            placeholder = {
                Text(text = "Ingresa el $title de la playlist", color = Color.Gray) // Placeholder más descriptivo
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.White,
                textColor = Color.White,
            ),
            textStyle = TextStyle(color = Color.White),
            modifier = Modifier.fillMaxWidth()
        )
    }
}



