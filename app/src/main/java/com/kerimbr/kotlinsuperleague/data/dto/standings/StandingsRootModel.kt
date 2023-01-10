package com.kerimbr.kotlinsuperleague.data.dto.standings


import com.google.gson.annotations.SerializedName

data class StandingsRootModel(
    @SerializedName("response")
    val standingsResponse: List<StandingsResponse>,
)