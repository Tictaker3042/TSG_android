package com.example.android

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {

    @POST("/api/check_auth")
    suspend fun loginUser(@Body userData: UserData)


}