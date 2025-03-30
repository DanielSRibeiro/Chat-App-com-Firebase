package com.example.realtimechat.data.datasource.firestore

import com.example.realtimechat.data.domain.usecase.base.ResultStatus
import com.example.realtimechat.data.domain.model.Contact
import com.example.realtimechat.data.domain.model.Message
import com.example.realtimechat.data.domain.model.User

interface FirebaseFireStoreDataSource {
    suspend fun createUser(user: User): ResultStatus<User>
    suspend fun getUserData(userUid: String): ResultStatus<User>
    suspend fun addNewContact(contact: Contact): ResultStatus<Contact>
    suspend fun getAllContact(contact: Contact): ResultStatus<Contact>
    suspend fun getAllMessage(contact: Contact): ResultStatus<Message>
    suspend fun sendMessage(message: Message): ResultStatus<Message>
}