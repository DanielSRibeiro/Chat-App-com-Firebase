package com.example.realtimechat.data.repository

import com.example.realtimechat.data.domain.ResultStatus

interface FirebaseAuthenticationDataSource {
    suspend fun processAuthentication(
        email: String,
        password: String,
        callback: (ResultStatus<String>) -> Unit,

    )
    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
        callback: (ResultStatus<String>) -> Unit,
    )
}