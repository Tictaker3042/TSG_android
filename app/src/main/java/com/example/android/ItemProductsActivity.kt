package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android.databinding.ActivityItemProductsBinding

class ItemProductsActivity : AppCompatActivity() {

    lateinit var binding: ActivityItemProductsBinding
    private lateinit var viewModel: ItemProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityItemProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = (application as UsersApp).itemProductsViewModel

        val product_id = intent.extras?.getInt("product_id") ?: return

        // Получите данные о товаре
        viewModel.getProductData(product_id, binding)


        binding.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}
