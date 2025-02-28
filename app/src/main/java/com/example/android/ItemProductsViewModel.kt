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
            binding.coldView.text = userData.cold_water
            binding.hotView.text = userData.hot_water
            binding.ownerView.text = userData.owner
            binding.roomView.text = userData.room_number.toString()
            binding.electricitydayView.text = userData.electricity_day
            binding.electricitynightView.text = userData.electricity_night
            binding.transferView.text = userData.transfer_date
        } else {
            // Обработка случая, когда данные не найдены
            binding.ownerView.text = "Данные не найдены"
            binding.roomView.text = ""
        }
    }
}