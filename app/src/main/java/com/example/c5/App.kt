package com.example.c5

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import com.example.c5.data.LoginUsecaseImpl
import com.example.c5.data.api.MockLoginApiImpl
import com.example.c5.domain.LoginApi
import com.example.c5.domain.LoginUsecase

class App:Application() {
    private val loginApi: LoginApi by lazy { MockLoginApiImpl() }
    val loginUsecase: LoginUsecase by lazy {LoginUsecaseImpl(app.loginApi, Handler(Looper.getMainLooper()))}
}

val Context.app :App
get() {
    return applicationContext as App
}
