package com.example.android

import com.google.gson.annotations.SerializedName

data class UserData(
    val login: String,
    val password: String,
    @SerializedName("user_id")
    val id: Int = 0
)

data class FavoriteData(
    val username: String?,
    val product_id: Int
)

data class ToggleResponse(
    val action: String
)

