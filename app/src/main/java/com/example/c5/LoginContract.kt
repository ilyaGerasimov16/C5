package com.example.c5

import androidx.annotation.MainThread

class LoginContract {

    interface LoginView{
        @MainThread
        fun setProgress()
        @MainThread
        fun hideProgress()
        @MainThread
        fun setError(error: String)
        @MainThread
        fun setSuccess()
    }

    interface LoginPresenter{
        fun onLogin(login:String, password:String)
        fun onAttach(view: LoginView)
        fun checkCredentials(login: String, password: String)
    }
}