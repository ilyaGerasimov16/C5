package com.example.c5

import androidx.annotation.MainThread

class LoginContract {

    interface View {
        @MainThread
        fun setProgress()

        @MainThread
        fun hideProgress()

        @MainThread
        fun setError(error: String)

        @MainThread
        fun setSuccess()
    }

    interface Presenter {
        fun onLogin(login: String, password: String)
        fun onAttach(view: View)
        fun checkCredentials(login: String, password: String): Boolean
    }
}