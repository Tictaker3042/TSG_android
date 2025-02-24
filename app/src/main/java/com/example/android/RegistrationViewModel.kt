package com.example.android

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    fun createUser(binding: ActivityRegistrationBinding) = viewModelScope.launch(dispatcher) {
        try {
            val login = binding.loginEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            repository.createUser(login, password)

            binding.loginEditText.text?.clear()
            binding.passwordEditText.text?.clear()
        } catch (e: Exception) {
            Toast.makeText(
                binding.root.context, "Пользователь с таким логином уже существует",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}