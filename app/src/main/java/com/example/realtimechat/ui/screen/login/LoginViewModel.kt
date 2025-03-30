package com.example.realtimechat.ui.screen.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realtimechat.data.domain.usecase.base.ResultStatus
import com.example.realtimechat.data.repository.authentication.FirebaseAuthenticationRepository
import com.example.realtimechat.ui.screen.login.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val firebaseAuthenticationRepository: FirebaseAuthenticationRepository
): ViewModel(){

    var uiState by mutableStateOf(LoginState())
        private set

    fun signIn() {
        if (uiState.emailInfo.isNotEmpty() && uiState.password.isNotEmpty()) {
            viewModelScope.launch {
                val result = firebaseAuthenticationRepository.signInWithEmailAndPassword(
                    email = uiState.emailInfo,
                    password = uiState.password
                )
                when (result) {
                    is ResultStatus.Error -> {
                        Log.d("ResultStatus", result.throwable.toString())
                    }

                    ResultStatus.Loading -> {
                        Log.d("ResultStatus", "resultStatus.throwable.toString()")
                    }

                    is ResultStatus.Success -> {
                        uiState = uiState.copy(
                            isPasswordError = false,
                            isEmailError = false,
                            isSuccess = true
                        )
                    }
                }
            }
        }
    }

    fun onChangeEmailValue(email: String) {
        if (email.length <= 50) {
            uiState = uiState.copy(emailInfo = email)
        }
    }

    fun onChangePasswordValue(password: String) {
        if (password.length <= 20) {
            uiState = uiState.copy(password = password)
        }
    }
}