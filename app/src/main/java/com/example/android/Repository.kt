package com.example.android

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
            return@withContext service.getProducts()
        }
    }


    suspend fun getProduct(product_id: Int): UserData {
        return withContext(dispatcher){
            return@withContext service.getProduct(product_id)
        }
    }

}