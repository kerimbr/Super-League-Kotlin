package com.kerimbr.kotlinsuperleague.data.dto.fixture

import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("extratime")
    val extraTime: Extratime,
    @SerializedName("fulltime")
    val fullTime: Fulltime,
    @SerializedName("halftime")
    val halfTime: Halftime,
    val penalty: Penalty
)