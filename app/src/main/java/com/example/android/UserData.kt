package com.example.android

import com.google.gson.annotations.SerializedName

data class UserData(
    val username: String,
    val password: String,
    @SerializedName("user_id")
    val id: Int = 0
)


