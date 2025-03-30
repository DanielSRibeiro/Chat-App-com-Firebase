package com.example.realtimechat.data.domain.model

data class Message(
    val text: String = "",
    val sender: String = "",
    val timestamp: Long = 0
)