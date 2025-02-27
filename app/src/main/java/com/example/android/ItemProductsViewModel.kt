package com.example.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.databinding.ActivityItemProductsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ItemProductsViewModel(
    private val repository: Repository,
    private val baseUrl: String
) : ViewModel() {

    fun getProductData(roomNumber: Int, binding: ActivityItemProductsBinding) = viewModelScope.launch(Dispatchers.Main) {
        val userDataList = repository.getProduct(roomNumber)
        if (userDataList.isNotEmpty()) {
            val userData = userDataList[0]  // Берем первый элемент массива
            binding.documentView.text = userData.document_number
            binding.amountView.text = userData.amount
        } else {
            // Обработка случая, когда данные не найдены
            binding.documentView.text = "Данные не найдены"
            binding.amountView.text = ""
        }
    }
}