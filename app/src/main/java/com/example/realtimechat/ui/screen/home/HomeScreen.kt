package com.example.realtimechat.ui.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.realtimechat.ui.navigation.HomeRoute
import com.example.realtimechat.ui.navigation.LoginRoute
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(
    navController: NavHostController,
    firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance(),
    list: List<Any> = emptyList(),
) {

    LaunchedEffect(key1 = firebaseAuth.currentUser) {
        if (firebaseAuth.currentUser == null) {
            navController.navigate(LoginRoute) {
                popUpTo(HomeRoute) { inclusive = true }
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(list.size, key = {}) {

        }
    }
}