package com.example.c5

class MockLoginApi : LoginApi {
    override fun login(login: String, password: String): Boolean {
        return login == password
    }

    override fun register(login: String, password: String, email: String): Boolean {
        return login.isNotEmpty() && password.isNotEmpty()
    }

    override fun logout(): Boolean {
        return true
    }

    override fun forgotPassword(login: String): Boolean {
        return true
    }
}