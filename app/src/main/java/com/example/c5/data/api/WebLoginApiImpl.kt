package com.example.c5.data.api

import com.example.c5.domain.LoginApi

class WebLoginApiImpl: LoginApi {
    override fun login(login: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun register(login: String, password: String, email: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun logout(): Boolean {
        TODO("Not yet implemented")
    }

    override fun forgotPassword(login: String): Boolean {
        TODO("Not yet implemented")
    }
}