package com.example.proyectoplatsreal.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.proyectoplatsreal.R
import com.example.proyectoplatsreal.ui.ajustes.AjustesScreen
import com.example.proyectoplatsreal.ui.escuchando.ListeningScreen
import com.example.proyectoplatsreal.ui.escuchando.PublishSongScreen
import com.example.proyectoplatsreal.ui.playlists.PlaylistsScreen
import com.example.proyectoplatsreal.ui.principal.MainScreen
import com.example.proyectoplatsreal.ui.theme.ProyectoPlatsrealTheme
import com.example.proyectoplatsreal.ui.theme.secondarydark

enum class MainTab(val title: String, val icon: Int) {
    AJUSTES("Ajustes", R.drawable.settings),
    PLAYLISTS("Playlists", R.drawable.playlist),
    LISTENING("Escuchando", R.drawable.headphones),
    SEARCH("Buscar", R.drawable.search)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicApp() {
    val navController = rememberNavController()
    var isDarkMode by remember { mutableStateOf(false) }

    ProyectoPlatsrealTheme(darkTheme = isDarkMode) {
        Scaffold(
            content = {
                NavHost(navController = navController, startDestination = Screen.SearchScreen.route) {
                    composable(Screen.SearchScreen.route) {
                        MainScreen()
                    }
                    composable(Screen.ListeningScreen.route) {
                        ListeningScreen(navController)
                    }
                    composable(Screen.PublishSongScreen.route) {
                        PublishSongScreen(navController)
                    }
                    composable(Screen.PlaylistsScreen.route) {
                        PlaylistsScreen()
                    }
                    composable(Screen.AjustesScreen.route) {
                        AjustesScreen(isDarkMode = isDarkMode, onDarkModeChange = { isDarkMode = it })
                    }
                }
            },
            bottomBar = {
                BottomTabs(navController)
            }
        )
    }
}


@Composable
fun BottomTabs(navController: NavController) {
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colorScheme.secondary
    ) {
        MainTab.values().forEach { tab ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = tab.icon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                },
                label = {
                    Text(
                        text = tab.title,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                },
                selected = currentRoute(navController) == when(tab) {
                    MainTab.SEARCH -> Screen.SearchScreen.route
                    MainTab.LISTENING -> Screen.ListeningScreen.route
                    MainTab.PLAYLISTS -> Screen.PlaylistsScreen.route
                    MainTab.AJUSTES -> Screen.AjustesScreen.route
                    else -> ""
                },
                onClick = {
                    when(tab) {
                        MainTab.SEARCH -> navController.navigate(Screen.SearchScreen.route)
                        MainTab.LISTENING -> navController.navigate(Screen.ListeningScreen.route)
                        MainTab.PLAYLISTS -> navController.navigate(Screen.PlaylistsScreen.route)
                        MainTab.AJUSTES -> navController.navigate(Screen.AjustesScreen.route)
                        else -> {}
                    }
                }
            )
        }
    }
}




@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    return navBackStackEntry?.destination?.route
}

