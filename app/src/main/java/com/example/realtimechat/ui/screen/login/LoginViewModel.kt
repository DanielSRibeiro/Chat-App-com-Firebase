package com.example.realtimechat.ui.screen.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realtimechat.data.domain.ResultStatus
import com.example.realtimechat.data.repository.FirebaseAuthenticationDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val firebaseAuthenticationDataSource: FirebaseAuthenticationDataSource
): ViewModel(){

    var uiState by mutableStateOf(LoginState())
        private set

    fun signInWithEmailAndPassword() {
        if (uiState.emailInfo.isNotEmpty() && uiState.password.isNotEmpty()) {
            viewModelScope.launch {
                firebaseAuthenticationDataSource.signInWithEmailAndPassword(
                    email = uiState.emailInfo,
                    password = uiState.password,
                    callback = { resultStatus ->
                        when (resultStatus) {
                            is ResultStatus.Error -> {
                                Log.d("ResultStatus", resultStatus.throwable.toString())
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
                )
            }
        }
    }

    fun eventEmail(email: String) {
        if (email.length <= 40) {
            uiState = uiState.copy(emailInfo = email)
        }
    }

    fun eventPassword(password: String) {
        if (password.length <= 40) {
            uiState = uiState.copy(password = password)
        }
    }
}

data class LoginState(
    val emailInfo: String = "",
    val password: String = "",
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
    val isSuccess: Boolean = false,
)