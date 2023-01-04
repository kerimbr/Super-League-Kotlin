package com.kerimbr.kotlinsuperleague.data.dto.fixture

import com.google.gson.annotations.SerializedName

data class FixtureRootModel(
    @SerializedName("response")
    val fixtureResponse: List<FixtureResponse>,
)