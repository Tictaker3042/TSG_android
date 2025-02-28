package com.example.android

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {

    @POST("/api/check_auth")
    suspend fun loginUser(@Body loginData: LoginData)

    @GET("/api/public_utilities")
    suspend fun getProduct() : List<UserData>

    @GET("/api/public_utilities/{room_number}")
    suspend fun getProduct(@Path("room_number") roomNumber: Int): List<UserData>

    @GET("/api/latest_payments")
    suspend fun getInfo() : List<UserData>

    @GET("/api/latest_payments/{room_number}")
    suspend fun getInfo(@Path("room_number") roomNumber: Int): List<UserData>

}