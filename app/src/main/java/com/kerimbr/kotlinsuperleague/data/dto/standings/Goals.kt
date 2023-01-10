package com.kerimbr.kotlinsuperleague.data.dto.standings


import com.google.gson.annotations.SerializedName

data class Goals(
    @SerializedName("against")
    val against: Int,
    @SerializedName("for")
    val forX: Int
)