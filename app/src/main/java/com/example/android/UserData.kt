package com.example.android

import com.google.gson.annotations.SerializedName

data class UserData(
    val amount: String,
    val cold_water: String,
    val document_number: String,
    val electricity_day: String,
    val electricity_night: String,
    val hot_water: String,
    val owner: String,
    @SerializedName("room_number")
    val room_number: Int,
    val transfer_date: String,
    val last_payment_date: String
)


