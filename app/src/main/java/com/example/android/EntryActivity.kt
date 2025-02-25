package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.databinding.ActivityEntryBinding

class EntryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val entryViewModel = (application as UsersApp).entryViewModel

        // Обработка входа
        binding.enterButton.setOnClickListener {
            entryViewModel.loginUser (binding)
        }



        binding.enterButton.setOnClickListener {
            val login = binding.loginEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            when {
                login.isEmpty() -> {
                    binding.loginInput.error = "Введите логин"
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

                    entryViewModel.loginUser(binding)
                }
            }
        }

        binding.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()

        }

    }
}

