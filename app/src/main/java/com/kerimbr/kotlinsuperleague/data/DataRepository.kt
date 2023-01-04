package com.kerimbr.kotlinsuperleague.data

import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureRootModel
import kotlinx.coroutines.flow.Flow


interface DataRepository {

    suspend fun getAllFixtures() : Flow<Resource<FixtureRootModel>>

}