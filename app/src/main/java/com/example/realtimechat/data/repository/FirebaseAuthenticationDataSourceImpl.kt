package com.example.realtimechat.data.repository

import android.util.Log
import com.example.realtimechat.data.domain.ResultStatus
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class FirebaseAuthenticationDataSourceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : FirebaseAuthenticationDataSource {

    override suspend fun processAuthentication(
        email: String,
        password: String,
        callback: (ResultStatus<String>) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback(ResultStatus.Success("Realizado com sucesso"))
                } else {
                    Log.d("ResultStatus", "Error: ${task.exception}")
                }
            }
    }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
        callback: (ResultStatus<String>) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback(ResultStatus.Success("Realizado com sucesso"))
                } else {
                    Log.d("ResultStatus", "Error: ${task.exception}")
                }
            }
    }
}