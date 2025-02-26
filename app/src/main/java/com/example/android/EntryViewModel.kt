package com.example.android

import SecureStorage
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.databinding.ActivityEntryBinding
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntryViewModel(
    private val repository: Repository,
    private val secureStorage: SecureStorage, // Добавляем SecureStorage
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    fun loginUser (binding: ActivityEntryBinding) = viewModelScope.launch(dispatcher) {
        val login = binding.loginEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        // Проверка на пустые значения
        if (login.isBlank() || password.isBlank()) {
            Toast.makeText(
                binding.root.context,
                "Логин и пароль не могут быть пустыми",
                Toast.LENGTH_SHORT
            ).show()
            return@launch
        }

        try {
            // Попытка входа
            repository.loginUser (login, password)

            //очистка учетных данных старого пользователя
            secureStorage.clearCredentials()
            // Сохранение учетных данных
            secureStorage.saveCredentials(login, password)

            // Очистка полей ввода
            binding.loginEditText.text?.clear()
            binding.passwordEditText.text?.clear()

            // Переход на следующий экран
            val intent = Intent(binding.root.context, MainActivity::class.java)
            binding.root.context.startActivity(intent)
        } catch (e: Exception) {
            // Обработка ошибки
            Toast.makeText(
                binding.root.context,
                "Неправильный логин или пароль",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}


