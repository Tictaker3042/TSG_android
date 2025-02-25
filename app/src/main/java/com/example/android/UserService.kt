package com.example.android

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {

    @POST("/user/create/mob")
    suspend fun createUser(@Body userData: UserData)

    @POST("/user/login")
    suspend fun loginUser(@Body userData: UserData)


}