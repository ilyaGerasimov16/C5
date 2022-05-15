package com.example.c5.data.userrepo

import com.example.c5.domain.UserRepo
import com.example.c5.domain.entities.UserProfile

class RoomUserRepoImpl:UserRepo {
    override fun addUser(userProfile: UserProfile) {
        TODO("Not yet implemented")
    }

    override fun getAllUsers(): List<UserProfile> {
        TODO("Not yet implemented")
    }

    override fun changeUser(id: String, user: UserProfile) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(id: String) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }
}