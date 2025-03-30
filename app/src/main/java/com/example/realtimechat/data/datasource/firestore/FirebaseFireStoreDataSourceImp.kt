package com.example.realtimechat.data.datasource.firestore

import com.example.realtimechat.data.domain.usecase.base.ResultStatus
import com.example.realtimechat.data.domain.model.Contact
import com.example.realtimechat.data.domain.model.Message
import com.example.realtimechat.data.domain.model.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseFireStoreDataSourceImp @Inject constructor(
    private val firestore: FirebaseFirestore
) : FirebaseFireStoreDataSource {

    override suspend fun createUser(user: User): ResultStatus<User> {
        return try {
            val userMap = mapOf(
                "uid" to user.uid,
                "name" to user.name,
                "email" to user.email,
                "password" to user.password,
                "contact" to emptyList<Contact>(),
            )
            firestore.collection("users").document(user.uid)
                .set(userMap).await()

            ResultStatus.Success(user)
        } catch (e: Exception) {
            ResultStatus.Error(e)
        }
    }

    override suspend fun getUserData(userUid: String): ResultStatus<User> {
        return try {
            val document = firestore.collection("users").document(userUid).get().await()

            if (document.exists()) {
                val user = document.toObject(User::class.java)
                user?.let { ResultStatus.Success(user) }
                    ?: ResultStatus.Error(Exception("Usuário não encontrado"))
            } else {
                ResultStatus.Error(Exception("Usuário não encontrado"))
            }
        } catch (e: Exception) {
            ResultStatus.Error(e)
        }
    }

    override suspend fun addNewContact(contact: Contact): ResultStatus<Contact> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllContact(contact: Contact): ResultStatus<Contact> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllMessage(contact: Contact): ResultStatus<Message> {
        TODO("Not yet implemented")
    }

    override suspend fun sendMessage(message: Message): ResultStatus<Message> {
        TODO("Not yet implemented")
    }
}