package com.example.android

import SecureStorage
import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UsersApp : Application() {

    val baseUrl = "http://192.168.1.33:5000"

    // Создание Retrofit в методе onCreate
    private lateinit var retrofit: Retrofit
    private lateinit var service: UserService
    private lateinit var repository: Repository
    lateinit var secureStorage: SecureStorage

    // Инициализация ViewModel
    lateinit var registrationViewModel: RegistrationViewModel
    lateinit var entryViewModel: EntryViewModel
    lateinit var productsViewModel: ProductsViewModel
    lateinit var itemProductsViewModel: ItemProductsViewModel
    lateinit var favoriteProductsViewModel: FavoriteProductsViewModel
    lateinit var itemFavoriteProductsViewModel: ItemFavoriteProductsViewModel

    override fun onCreate() {
        super.onCreate()

        // Инициализация Retrofit
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(UserService::class.java)
        repository = Repository(service)

        // Инициализация SecureStorage
        secureStorage = SecureStorage(this)

        // Инициализация ViewModel
        registrationViewModel = RegistrationViewModel(repository)
        entryViewModel = EntryViewModel(repository, secureStorage)
        productsViewModel = ProductsViewModel(repository)
        itemProductsViewModel = ItemProductsViewModel(repository, baseUrl)
        favoriteProductsViewModel = FavoriteProductsViewModel(repository)
        itemFavoriteProductsViewModel = ItemFavoriteProductsViewModel(repository,baseUrl)
    }
}
