package com.example.realtimechat.data.repository.authentication

import com.example.realtimechat.data.datasource.authentication.FirebaseAuthenticationDataSource
import com.example.realtimechat.data.domain.usecase.base.ResultStatus
import javax.inject.Inject

class FirebaseAuthenticationRepositoryImp @Inject constructor(
    private val dataSource: FirebaseAuthenticationDataSource
) : FirebaseAuthenticationRepository {

    override suspend fun signUpWithEmailAndPassword(
        name: String,
        email: String,
        password: String
    ): String {
        return dataSource.signUpWithEmailAndPassword(name, email, password)
    }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ) : ResultStatus<String> {
        return dataSource.signInWithEmailAndPassword(email, password)
    }
}