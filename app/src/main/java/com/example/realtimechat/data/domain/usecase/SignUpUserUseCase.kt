package com.example.realtimechat.data.domain.usecase

import com.example.realtimechat.data.domain.model.User
import com.example.realtimechat.data.domain.usecase.base.ResultStatus
import com.example.realtimechat.data.domain.usecase.base.UseCase
import com.example.realtimechat.data.repository.authentication.FirebaseAuthenticationRepository
import com.example.realtimechat.data.repository.firestore.FirebaseFireStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface SignUpUserUseCase {
    operator fun invoke(params: Params): Flow<ResultStatus<User>>
    data class Params(
        val name: String,
        val email: String,
        val password: String,
    )
}

class SignUpUserUseCaseImpl @Inject constructor(
    private val authenticationRepository: FirebaseAuthenticationRepository,
    private val firestoreRepository: FirebaseFireStoreRepository,
) : UseCase<SignUpUserUseCase.Params, User>(), SignUpUserUseCase {
    override suspend fun doWork(params: SignUpUserUseCase.Params): ResultStatus<User> {

        val userUid = authenticationRepository.signUpWithEmailAndPassword(
            name = params.name,
            email = params.email,
            password = params.password,
        )

        val user = User(
            uid = userUid,
            name = params.name,
            email = params.email,
            password = params.password
        )

        val firestoreResult = firestoreRepository.saveUserToFireStore(user)

        return firestoreResult
    }

}