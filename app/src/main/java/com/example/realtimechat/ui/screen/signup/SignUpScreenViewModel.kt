package com.example.realtimechat.ui.screen.signup

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
class SignUpScreenViewModel @Inject constructor(
    private val firebaseAuthenticationDataSource: FirebaseAuthenticationDataSource
) : ViewModel() {

    var uiState by mutableStateOf(SignUpState())
        private set

    fun processAuthentication() {
        if (uiState.emailInfo.length >= 15 && uiState.password.length >= 6) {
            viewModelScope.launch {
                firebaseAuthenticationDataSource.processAuthentication(
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

data class SignUpState(
    val emailInfo: String = "",
    val password: String = "",
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
    val isSuccess: Boolean = false,
)