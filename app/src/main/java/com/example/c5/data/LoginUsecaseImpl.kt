package com.example.c5.data

import android.os.Handler
import androidx.annotation.MainThread
import com.example.c5.domain.LoginApi
import com.example.c5.domain.LoginUsecase

class LoginUsecaseImpl(private val loginApi: LoginApi, private val uiHandler: Handler) : LoginUsecase {
    override fun login(login: String,
                       password: String,
                       @MainThread callback: (Boolean) -> Unit
    ) {
        Thread {
            val result = loginApi.login(login, password)
            uiHandler.post {
                callback(result)
            }
        }.start()
    }
}