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
            service.loginUser(UserData(username, password))
        }
    }


}