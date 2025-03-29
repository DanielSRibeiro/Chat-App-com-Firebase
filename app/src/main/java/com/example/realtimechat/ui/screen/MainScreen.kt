package com.example.realtimechat.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.realtimechat.ui.navigation.NavigationGraph
import com.google.firebase.auth.FirebaseAuth

@Composable
fun MainScreen() {
    Scaffold(
        topBar = {

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    FirebaseAuth.getInstance().signOut()
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavigationGraph(navController = rememberNavController())
        }
    }

}