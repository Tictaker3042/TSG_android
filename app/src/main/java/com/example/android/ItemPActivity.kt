package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android.databinding.ActivityItemPactivityBinding
import com.example.android.databinding.ActivityItemProductsBinding
import com.example.android.databinding.ItemPBinding

class ItemPActivity : AppCompatActivity() {

    lateinit var binding: ActivityItemPactivityBinding
    private lateinit var viewModel: ItemPViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityItemPactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = (application as UsersApp).itemPViewModel

        val roomNumber = intent.extras?.getInt("room_number") ?: return

        // Получите данные о товаре
        viewModel.getProductData(roomNumber, binding)


        binding.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}
