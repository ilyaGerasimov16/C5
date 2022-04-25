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

class LoginActivity : AppCompatActivity(),LoginContract.View {
    private lateinit var binding:ActivityLoginBinding
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = restorePresenter()
        presenter.onAttach(this)


        binding.buttonLogin.setOnClickListener{
            presenter.onLogin(binding.editTextLogin.text.toString(),binding.editTextPassword.text.toString())
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
        Toast.makeText(this,"Error: $error",Toast.LENGTH_SHORT).show()
    }

    @MainThread
    override fun setSuccess() {
        binding.editTextLogin.isVisible = false
        binding.editTextPassword.isVisible = false
        binding.buttonLogin.isVisible = false
        binding.buttonRegister.isVisible = false
        binding.textViewRestorePassword.isVisible = false
        binding.root.setBackgroundColor(Color.GREEN)
        Toast.makeText(this, "Успешно", Toast.LENGTH_SHORT).show()
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }


    private fun restorePresenter(): LoginPresenter{
        val presenter = lastCustomNonConfigurationInstance as? LoginPresenter
        return presenter?: LoginPresenter()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return presenter
    }
}