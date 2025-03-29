package com.example.realtimechat.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.realtimechat.ui.screen.home.HomeScreen
import com.example.realtimechat.ui.screen.login.LoginScreen
import com.example.realtimechat.ui.screen.signup.SignUpScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home
    ) {
        composable(Screens.Home.route) {
            HomeScreen()
        }
        composable(Screens.Login.route) {
            LoginScreen()
        }
        composable(Screens.SignUp.route) {
            SignUpScreen()
        }
    }
}