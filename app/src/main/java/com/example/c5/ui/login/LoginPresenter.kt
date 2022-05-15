package com.example.c5.ui.login

import android.os.Handler
import android.os.Looper
import com.example.c5.domain.LoginApi

class LoginPresenter(private val loginApi: LoginApi) : LoginContract.Presenter {
    private lateinit var view: LoginContract.View
    private val mainThreadHandler = Handler(Looper.getMainLooper())
    private var isSuccess = false
    private var textError = ""

    private val errorEmptyLogin = "Введите логин!"
    private val errorEmptyPassword = "Введите пароль!"
    private val errorWrongLoginDetails = "Неверно введён логин или пароль!"

    override fun onLogin(login: String, password: String) {
        view.setProgress()
        Thread {
            val success = loginApi.login(login,password)
            mainThreadHandler.post {
                view.hideProgress()
                if (success) {
                    view.setSuccess()
                    isSuccess = true
                    textError = ""
                } else {
                    when {
                        login == "" -> {
                            view.setError(errorEmptyLogin)
                            textError = errorEmptyLogin
                            isSuccess = false
                        }
                        password == "" -> {
                            view.setError(errorEmptyPassword)
                            textError = errorEmptyPassword
                            isSuccess = false
                        }
                        else -> {
                            view.setError(errorWrongLoginDetails)
                            textError = errorWrongLoginDetails
                            isSuccess = false
                        }
                    }
                }
            }
        }.start()
    }

    override fun onAttach(view: LoginContract.View) {
        this.view = view
        if (isSuccess) {
            view.setSuccess()
        } else {
            view.setError(textError)
        }
    }
}