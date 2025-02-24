package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val registrationViewModel = (application as UsersApp).registrationViewModel

        // RegistrationActivity.kt
        binding.registrationButton.setOnClickListener {
            val login = binding.loginEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            when {
                login.isEmpty() -> {
                    binding.loginInput.error = "Введите email"
                    binding.loginEditText.requestFocus()
                }
                password.isEmpty() -> {
                    binding.passwordInput.error = "Введите пароль"
                    binding.passwordEditText.requestFocus()
                }
                else -> {
                    // Сброс ошибок
                    binding.loginInput.error = null
                    binding.passwordInput.error = null

                    registrationViewModel.createUser(binding)
                }
            }
        }

        binding.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()

        }

    }
}
