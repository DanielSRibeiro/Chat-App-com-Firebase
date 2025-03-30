package com.example.realtimechat.data.datasource.authentication

import com.example.realtimechat.data.domain.usecase.base.ResultStatus
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthenticationDataSourceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : FirebaseAuthenticationDataSource {

    override suspend fun signUpWithEmailAndPassword(
        name: String,
        email: String,
        password: String
    ): String {
        val authResult = auth.createUserWithEmailAndPassword(email, password).await()
        return authResult.user!!.uid
    }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): ResultStatus<String> {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            ResultStatus.Success("Realizado com sucesso")
        } catch (e: Exception) {
            ResultStatus.Error(e)
        }
    }
}