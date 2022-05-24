package com.example.c5.ui.login

import androidx.annotation.MainThread

interface LoginContract {

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
        @MainThread
        fun onLogin(login: String, password: String)

        @MainThread
        fun onAttach(view: View)
    }
}