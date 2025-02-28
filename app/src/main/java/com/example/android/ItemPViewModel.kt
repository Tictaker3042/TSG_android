package com.example.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.databinding.ActivityItemPactivityBinding
import com.example.android.databinding.ActivityItemProductsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ItemPViewModel(
    private val repository: Repository,
    private val baseUrl: String
) : ViewModel() {

    fun getInfoData(roomNumber: Int, binding: ActivityItemPactivityBinding) = viewModelScope.launch(Dispatchers.Main) {
        val userDataList = repository.getInfo(roomNumber)
        if (userDataList.isNotEmpty()) {
            val userData = userDataList[0]  // Берем первый элемент массива
            print(userData)
            binding.documentView.text = userData.document_number
            binding.amountView.text = userData.amount
            binding.ownerView.text = userData.owner
            binding.roomView.text = userData.room_number.toString()
            binding.tranferView.text = userData.transfer_date
        } else {
            // Обработка случая, когда данные не найдены
            binding.documentView.text = "Данные не найдены"
            binding.amountView.text = ""
        }
    }
}