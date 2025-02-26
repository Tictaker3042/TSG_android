package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val baseUrl = (application as UsersApp).baseUrl

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val layoutManager = GridLayoutManager(this, 1)
        binding.recyclerView.layoutManager = layoutManager

        val lambda: (id: Int) -> Unit = { id ->
            val intent = Intent(this, ItemProductsActivity::class.java).apply {
                putExtra("product_id", id)
            }
            startActivity(intent)
        }

        val adapter = UsersListAdapter(baseUrl, emptyList(), lambda)
        binding.recyclerView.adapter = adapter

        val itemProductsViewModel = (application as UsersApp).productsViewModel
        itemProductsViewModel.getProduct(adapter)


        binding.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}

