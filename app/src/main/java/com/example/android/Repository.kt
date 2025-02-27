package com.example.android

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(
    private val service: UserService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {


    suspend fun loginUser(username: String, password: String) {
        withContext(dispatcher) {
            service.loginUser(LoginData(username, password))
        }
    }

    suspend fun getProduct(): List<UserData> {
        return withContext(dispatcher) {
            val products = service.getProducts()
            Log.d("Repository", "Data from server: $products")
            products
        }
    }


    suspend fun getProduct(roomNumber: Int): List<UserData> {
        return withContext(dispatcher) {
            return@withContext service.getProduct(roomNumber)
        }
    }

}