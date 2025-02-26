package com.example.android

import com.google.gson.annotations.SerializedName

data class LoginData(
    val username: String,
    val password: String,
    @SerializedName("user_id")
    val id: Int = 0,
)


