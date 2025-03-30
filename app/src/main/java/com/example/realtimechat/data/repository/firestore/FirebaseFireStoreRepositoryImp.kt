package com.example.realtimechat.data.repository.firestore

import com.example.realtimechat.data.datasource.firestore.FirebaseFireStoreDataSource
import com.example.realtimechat.data.domain.model.Contact
import com.example.realtimechat.data.domain.model.Message
import com.example.realtimechat.data.domain.model.User
import com.example.realtimechat.data.domain.usecase.base.ResultStatus
import javax.inject.Inject

class FirebaseFireStoreRepositoryImp @Inject constructor(
    private val dataSource: FirebaseFireStoreDataSource
) : FirebaseFireStoreRepository {
    override suspend fun saveUserToFireStore(
        user: User
    ): ResultStatus<User> {
        return dataSource.createUser(user)
    }

    override suspend fun getUserData(userUid: String): ResultStatus<User> {
        return dataSource.getUserData(userUid)
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