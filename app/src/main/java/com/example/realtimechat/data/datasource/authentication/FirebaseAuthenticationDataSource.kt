package com.example.realtimechat.data.datasource.authentication

import com.example.realtimechat.data.domain.usecase.base.ResultStatus

interface FirebaseAuthenticationDataSource {
    suspend fun signUpWithEmailAndPassword(
        name: String,
        email: String,
        password: String,
    ): String

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): ResultStatus<String>
}