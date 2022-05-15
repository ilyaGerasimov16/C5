package com.example.c5.domain

import com.example.c5.domain.entities.UserProfile

interface UserRepo {

    fun addUser(userProfile: UserProfile)

    fun getAllUsers(): List<UserProfile>

    fun changeUser(id:String, user:UserProfile)

    fun deleteUser(id: String)
    fun deleteAll()

}