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

    fun getProductData(product_id: Int, binding: ActivityItemProductsBinding) = viewModelScope.launch(
        Dispatchers.Main) {

        val userData = repository.getProduct(product_id)
        binding.documentView.text = userData.document_number
        binding.amountView.text = userData.amount
    }
}