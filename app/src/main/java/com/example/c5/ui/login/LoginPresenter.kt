package com.example.c5.ui.login


import com.example.c5.domain.LoginUsecase

class LoginPresenter(private val loginUsecase: LoginUsecase) : LoginContract.Presenter {
    private lateinit var view: LoginContract.View
    private var isSuccess = false
    private var textError = ""

    private val errorEmptyLogin = "Введите логин!"
    private val errorEmptyPassword = "Введите пароль!"
    private val errorWrongLoginDetails = "Неверно введён логин или пароль!"

    override fun onLogin(login: String, password: String) {
        view.setProgress()

        loginUsecase.login(login, password){result ->
            view.hideProgress()
            if (result) {
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