package com.kerimbr.kotlinsuperleague.data.dto.fixture

data class FixtureResponse(
    val fixture: Fixture,
    val goals: Goals,
    val league: League,
    val score: Score,
    val teams: Teams
)