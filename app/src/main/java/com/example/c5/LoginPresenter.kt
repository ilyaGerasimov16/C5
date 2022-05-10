package com.example.c5

import android.os.Handler
import android.os.Looper

class LoginPresenter : LoginContract.Presenter {
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
            Thread.sleep(1_000)
            mainThreadHandler.post {
                view.hideProgress()
                if (checkCredentials(login, password) && login != "" && password != "") {
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

    override fun checkCredentials(login: String, password: String): Boolean {
        return login == password
    }
}