package com.example.realtimechat.data.domain.model

data class User(
    val uid: String,
    val name: String,
    val email: String,
    val password: String,
    val contact: List<Contact>? = emptyList(),
)