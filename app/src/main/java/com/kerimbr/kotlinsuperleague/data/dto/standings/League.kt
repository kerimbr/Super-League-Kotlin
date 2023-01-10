package com.kerimbr.kotlinsuperleague.data.dto.standings


import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("country")
    val country: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("season")
    val season: Int,
    @SerializedName("standings")
    val standings: List<List<Standing>>
)