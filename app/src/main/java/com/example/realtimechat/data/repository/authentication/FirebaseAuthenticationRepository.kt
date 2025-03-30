package com.example.realtimechat.data.repository.authentication

import com.example.realtimechat.data.domain.usecase.base.ResultStatus

interface FirebaseAuthenticationRepository {

    suspend fun signUpWithEmailAndPassword(
        name: String,
        email: String,
        password: String,
    ) : String

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ) : ResultStatus<String>
}