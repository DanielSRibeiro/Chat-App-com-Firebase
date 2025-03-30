package com.example.realtimechat.data.domain.model

data class Contact(
    val name: String,
    val email: String,
    val password: String,
    val message: List<Message> = emptyList()
)
