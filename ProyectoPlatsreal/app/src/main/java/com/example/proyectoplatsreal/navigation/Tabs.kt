package com.example.proyectoplatsreal.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectoplatsreal.R
import com.example.proyectoplatsreal.ui.principal.MainScreen
import com.example.proyectoplatsreal.ui.theme.secondarybc
import com.example.proyectoplatsreal.ui.theme.secondarydark


enum class MainTab(val title: String, val icon: Int) {
    AJUSTES("Agregar", R.drawable.settings),
    PLAYLISTS("Playlists", R.drawable.playlist),
    LISTENING("Escuchando", R.drawable.headphones),
    SEARCH("Buscar", R.drawable.search)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MusicApp(navController: NavController) {
    // Estado para recordar la pestaña/tab seleccionada.
    // Inicialmente es "SEARCH".
    val (selectedTab, setSelectedTab) = remember { mutableStateOf<MainTab>(MainTab.SEARCH) }

    // Recupera todos los valores de la enumeración MainTab.
    val tabs = MainTab.values()

    // Define un esqueleto para la aplicación.
    Scaffold(
        content = {
            // Columna que ocupa todo el espacio disponible.
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Decide qué pantalla mostrar basándose en la pestaña/tab seleccionada.
                when (selectedTab) {
                    MainTab.SEARCH -> MainScreen()
                    // Aquí puedes agregar el contenido de las otras tabs,
                    // como MainTab.LISTENING -> ListeningScreen() y así sucesivamente.
                    else -> Text("Contenido de la pestaña: ${selectedTab.title}")
                }
            }
        },
        bottomBar = {
            // Define la barra inferior de la aplicación.
            BottomAppBar(
                containerColor = secondarydark, // Color de fondo de la barra inferior.
                contentColor = Color.White
            ) {
                // Barra de navegación inferior.
                BottomTabs(
                    selectedTab = selectedTab,
                    onTabSelected = { setSelectedTab(it) }
                )

            }
        }
    )
}

@Composable
fun BottomTabs(selectedTab: MainTab, onTabSelected: (MainTab) -> Unit) {
    BottomNavigation(
        modifier = Modifier.fillMaxWidth().background(secondarydark),
        backgroundColor = secondarydark// Establece el fondo a `secondarydark` y llena el ancho.
    ) {
        MainTab.values().forEach { tab ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = tab.icon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp) // Tamaño del ícono reducido.
                    )
                },
                label = {
                    Text(
                        tab.title,
                        fontSize = 12.sp, // Tamaño de letra reducido.
                        modifier = Modifier.padding(0.dp)
                    )
                },
                selected = selectedTab == tab,
                onClick = { onTabSelected(tab) },
                alwaysShowLabel = true
            )
        }
    }
}


