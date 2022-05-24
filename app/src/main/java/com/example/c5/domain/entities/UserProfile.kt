package com.example.c5.domain.entities

data class UserProfile (
    val id: String,
    val login:String,
    val password:String,
    val email:String,
    val avatarUrl:String,
    val pin: Int
)