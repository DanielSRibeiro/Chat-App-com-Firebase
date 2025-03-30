package com.example.realtimechat.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.realtimechat.ui.screen.chat.ChatScreen
import com.example.realtimechat.ui.screen.home.HomeScreen
import com.example.realtimechat.ui.screen.login.LoginScreen
import com.example.realtimechat.ui.screen.login.LoginViewModel
import com.example.realtimechat.ui.screen.sign_up.SignUpScreen
import com.example.realtimechat.ui.screen.sign_up.SignUpScreenViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            HomeScreen(navController)
        }

        composable<ChatRoute> {
            ChatScreen()
        }

        composable<LoginRoute> {
            val viewModel = hiltViewModel<LoginViewModel>()
            val uiState = viewModel.uiState

            LoginScreen(
                uiState = uiState,
                onChangeEmailValue = viewModel::onChangeEmailValue,
                onChangePasswordValue = viewModel::onChangePasswordValue,
                signIn = viewModel::signIn,
                navigateToSignUp = { navController.navigate(SignUpRoute) },
                navigateToHome = { navController.navigate(HomeRoute) }
            )
        }

        composable<SignUpRoute> {
            val viewModel = hiltViewModel<SignUpScreenViewModel>()
            val uiState = viewModel.uiState

            SignUpScreen(
                uiState = uiState,
                onChangeNameValue = viewModel::onChangeNameValue,
                onChangeEmailValue = viewModel::onChangeEmailValue,
                onChangePasswordValue = viewModel::onChangePasswordValue,
                signUp = viewModel::signUp,
                navigateToHome = { navController.navigate(HomeRoute) }
            )
        }

        composable<SMSVerificationRoute> {
            val arguments = it.toRoute<SMSVerificationRoute>()

//            val db = FirebaseFirestore.getInstance()
//            val docRef = db.collection("users").document("3FxbhtyBT8E3fhCnEqbJ")
//            docRef.get().addOnSuccessListener { document ->
//                if (document != null) {
//                    Log.d("Users", "DocumentSnapshot data: ${document.data}")
//                } else {
//                    Log.d("Users", "No such document")
//                }
//            }

//            SMSVerificationScreen(
//                verification = verification
//            )
        }

    }
}