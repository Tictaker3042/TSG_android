package com.example.android

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(
    private val service: UserService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getProduct(): List<ProductData> {
        return withContext(dispatcher) {
            return@withContext service.getProducts()
        }
    }


    suspend fun getProduct(product_id: Int): ProductData {
        return withContext(dispatcher){
            return@withContext service.getProduct(product_id)
        }
    }

    suspend fun createUser(login: String, password: String) {
        withContext(dispatcher) {
            service.createUser(UserData(login, password))
        }
    }

    suspend fun loginUser(login: String, password: String) {
        withContext(dispatcher) {
            service.loginUser(UserData(login, password))
        }
    }

    suspend fun toggleFavorite(username: String?, productId: Int): String {
        val response = withContext(dispatcher) {
            service.toggleFavorite(FavoriteData(username, productId))
        }
        return response.action
    }

    suspend fun getFavoriteProducts(username: String?): List<ProductData> {
        return withContext(dispatcher) {
            service.getFavoriteProducts(username)
        }
    }

}