package com.example.c5.data

import com.example.c5.domain.LoginApi

class MockLoginApiImpl : LoginApi {
    override fun login(login: String, password: String): Boolean {
        Thread.sleep(1_000)
        return login == password && login != "" && password != ""
    }

    override fun register(login: String, password: String, email: String): Boolean {
        Thread.sleep(1_000)
        return login.isNotEmpty() && password.isNotEmpty()
    }

    override fun logout(): Boolean {
        Thread.sleep(1_000)
        return true
    }

    override fun forgotPassword(login: String): Boolean {
        Thread.sleep(1_000)
        return true
    }
}