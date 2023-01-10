package com.kerimbr.kotlinsuperleague.data.dto.standings


import com.google.gson.annotations.SerializedName

data class StandingsResponse(
    @SerializedName("league")
    val league: League
)