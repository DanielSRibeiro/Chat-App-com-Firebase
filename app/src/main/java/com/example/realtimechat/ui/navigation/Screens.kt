package com.example.realtimechat.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
object ChatRoute

@Serializable
object LoginRoute

@Serializable
object SignUpRoute

@Serializable
data class SMSVerificationRoute(
    val isToRegister: Boolean = false
)