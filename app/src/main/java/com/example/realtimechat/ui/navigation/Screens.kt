package com.example.realtimechat.ui.navigation

sealed class Screens(val route: String) {
    data object Home : Screens(route = "home")
    data object Login : Screens(route = "login")
    data object SignUp : Screens(route = "signUp")
}