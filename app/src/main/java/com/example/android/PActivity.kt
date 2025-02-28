package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.databinding.ActivityPactivityBinding
import com.example.android.databinding.ActivityProductsBinding

class PActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPactivityBinding.inflate(layoutInflater)
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
            val intent = Intent(this, ItemPActivity::class.java).apply {
                putExtra("room_number", id)
            }
            startActivity(intent)
        }

        val adapter = UListAdapter(baseUrl, emptyList(), lambda)
        binding.recyclerView.adapter = adapter

        val itemPViewModel = (application as UsersApp).pViewModel
        itemPViewModel.getInfo(adapter)


        binding.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}

