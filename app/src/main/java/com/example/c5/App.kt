package com.example.c5

import android.app.Application
import android.content.Context
import com.example.c5.data.MockLoginApiImpl
import com.example.c5.domain.LoginApi

class App:Application() {
    val loginApi: LoginApi by lazy { MockLoginApiImpl() }
}

val Context.app :App
get() {
    return applicationContext as App
}
