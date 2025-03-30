package com.example.realtimechat.ui.screen.login.state

data class LoginState(
    val emailInfo: String = "",
    val password: String = "",
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
    val isSuccess: Boolean = false,
)