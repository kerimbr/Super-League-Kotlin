package com.kerimbr.kotlinsuperleague.data

import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureRootModel
import com.kerimbr.kotlinsuperleague.data.dto.standings.StandingsRootModel
import kotlinx.coroutines.flow.Flow


interface DataRepository {

    suspend fun getAllFixtures() : Flow<Resource<FixtureRootModel>>

    suspend fun getNextFixtures() : Flow<Resource<FixtureRootModel>>

    suspend fun getLastFixtures() : Flow<Resource<FixtureRootModel>>

    suspend fun getStandings() : Flow<Resource<StandingsRootModel>>

}