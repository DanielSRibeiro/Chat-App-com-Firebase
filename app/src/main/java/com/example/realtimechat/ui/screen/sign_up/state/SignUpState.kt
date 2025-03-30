package com.example.realtimechat.ui.screen.sign_up.state

data class SignUpState(
    val name: String = "",
    val emailInfo: String = "",
    val password: String = "",
    val isNameError: Boolean = false,
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
    val isSuccess: Boolean = false,
)