package com.example.proyectoplatsreal.navigation

sealed class Screen(val route: String) {
    object SearchScreen : Screen("searchScreen")
    object ListeningScreen : Screen("listeningScreen")
    object PublishSongScreen : Screen("publishSongScreen")
    object PlaylistsScreen : Screen("playlistsScreen")
    object AjustesScreen : Screen("ajustesScreen")  // Nueva entrada
}
