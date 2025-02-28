package com.example.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PViewModel(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    fun getInfo(adapter: UListAdapter) = viewModelScope.launch(dispatcher) {

        val products = repository.getInfo()

        adapter.update(products) // Обновляем данные адаптера
    }
}