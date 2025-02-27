package com.example.android

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UsersApp : Application() {

    val baseUrl = "http://192.168.1.33:5000"

    // Создание Retrofit в методе onCreate
    private lateinit var retrofit: Retrofit
    private lateinit var service: UserService
    private lateinit var repository: Repository

    // Инициализация ViewModel
    lateinit var entryViewModel: EntryViewModel
    lateinit var productsViewModel: ProductsViewModel
    lateinit var itemProductsViewModel: ItemProductsViewModel
    override fun onCreate() {
        super.onCreate()

        // Инициализация Retrofit
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(UserService::class.java)
        repository = Repository(service)




        // Инициализация ViewModel
        entryViewModel = EntryViewModel(repository)
        productsViewModel = ProductsViewModel(repository)
        itemProductsViewModel = ItemProductsViewModel(repository, baseUrl)

    }
}
