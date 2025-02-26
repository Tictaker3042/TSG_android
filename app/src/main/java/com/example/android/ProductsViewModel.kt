package com.example.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    fun getProduct(adapter: UsersListAdapter) = viewModelScope.launch(dispatcher) {

        val products = repository.getProduct()

        adapter.update(products) // Обновляем данные адаптера
    }
}