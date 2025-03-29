package com.example.realtimechat.ui.screen.signup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun SignUpScreen(
    uiState: SignUpState,
    modifier: Modifier = Modifier,
    onChangeEmailValue: (String) -> Unit = {},
    onChangePasswordValue: (String) -> Unit = {},
    processAuthentication: () -> Unit = {},
    navigateToHome: () -> Unit,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(key1 = uiState.isSuccess) {
        if (uiState.isSuccess) {
            navigateToHome()
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sign Up", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Descrição", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth(),
                value = uiState.emailInfo,
                onValueChange = { onChangeEmailValue(it) },
                isError = uiState.isEmailError,
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "E-Mail")
                },
                label = { Text("E-Mail") },
                textStyle = MaterialTheme.typography.bodyLarge,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                supportingText = { Text("E-Mail") }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth(),
                value = uiState.password,
                onValueChange = { onChangePasswordValue(it) },
                isError = uiState.isPasswordError,
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                },
                supportingText = { Text("Mínimo 6 caracteres") },
                label = { Text("Senha") },
                textStyle = MaterialTheme.typography.bodyLarge,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier,
                onClick = {
                    processAuthentication()
                }
            ) {
                Text(text = "Avançar")
            }
        }
    }
}