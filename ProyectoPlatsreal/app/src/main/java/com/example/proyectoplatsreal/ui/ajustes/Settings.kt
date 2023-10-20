package com.example.proyectoplatsreal.ui.ajustes

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
import androidx.compose.material3.Divider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoplatsreal.R
import com.example.proyectoplatsreal.ui.theme.darkbackground
import com.example.proyectoplatsreal.ui.theme.secondarydark

@Composable
fun AjustesScreen() {
    // Estado mutable para el Switch de Dark Mode
    var isDarkMode by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkbackground)  // Usar un color fijo por ahora
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,  // Alineación desde la parte superior
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título "Ajustes"
            Text(
                text = "Ajustes",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),  // Asegúrate de cambiar esto por tu logo real
                contentDescription = "Logo",
                modifier = Modifier.size(150.dp)  // Ajusta el tamaño según lo necesites
            )

            Spacer(modifier = Modifier.height(40.dp))


            Divider(color = secondarydark)

            Spacer(modifier = Modifier.height(16.dp))
            // Dark Mode switch visualmente
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Dark Mode",
                    color = Color.White,
                    fontSize = 20.sp
                )

                Switch(
                    checked = isDarkMode,  // Usando el estado mutable
                    onCheckedChange = { isDarkMode = it },  // Cambiando el estado al presionar
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        uncheckedThumbColor = Color.White
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = secondarydark)
        }
    }
}


