package com.example.realtimechat.ui.screen.sign_up

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realtimechat.data.domain.usecase.SignUpUserUseCase
import com.example.realtimechat.data.domain.usecase.base.ResultStatus
import com.example.realtimechat.data.repository.authentication.FirebaseAuthenticationRepository
import com.example.realtimechat.ui.screen.sign_up.state.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpScreenViewModel @Inject constructor(
    private val signUpUserUseCase: SignUpUserUseCase
) : ViewModel() {

    var uiState by mutableStateOf(SignUpState())
        private set

    fun signUp() {
        if (uiState.name.isNotEmpty() && uiState.emailInfo.length >= 15 && uiState.password.length >= 6) {
            viewModelScope.launch {
                signUpUserUseCase.invoke(
                    SignUpUserUseCase.Params(
                        name = uiState.name,
                        email = uiState.emailInfo,
                        password = uiState.password
                    )
                ).collectLatest { result ->
                    when (result) {
                        is ResultStatus.Error -> {
                            uiState = uiState.copy(
                                isPasswordError = true,
                                isEmailError = true,
                                isSuccess = false
                            )
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
    }

    fun onChangeNameValue(name: String) {
        if (name.length <= 40) {
            uiState = uiState.copy(name = name)
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
