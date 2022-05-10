package com.example.c5

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.core.view.isVisible
import com.example.c5.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var presenter: LoginPresenter
    private var isButtonLoginPressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = restorePresenter()
        presenter.onAttach(this)


        binding.loginButton.setOnClickListener {
            isButtonLoginPressed = true
            presenter.onLogin(
                binding.loginEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }

    @MainThread
    override fun setProgress() {
        binding.loadingLayout.visibility = View.VISIBLE
        binding.root.hideKeyboard()

    }

    @MainThread
    override fun hideProgress() {
        binding.loadingLayout.visibility = View.GONE
    }

    @MainThread
    override fun setError(error: String) {
        if (isButtonLoginPressed){
            Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
        }
    }

    @MainThread
    override fun setSuccess() {
        binding.loginEditText.isVisible = false
        binding.passwordEditText.isVisible = false
        binding.loginButton.isVisible = false
        binding.registerButton.isVisible = false
        binding.restorePasswordTextView.isVisible = false
        binding.root.setBackgroundColor(Color.GREEN)
        if(isButtonLoginPressed){
            Toast.makeText(this, "Успешно", Toast.LENGTH_SHORT).show()
        }
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }


    private fun restorePresenter(): LoginPresenter {
        val presenter = lastCustomNonConfigurationInstance as? LoginPresenter
        return presenter ?: LoginPresenter()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return presenter
    }
}