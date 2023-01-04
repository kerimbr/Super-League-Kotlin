package com.kerimbr.kotlinsuperleague.data

import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureRootModel
import com.kerimbr.kotlinsuperleague.data.remote.data_source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : DataRepository {

    override suspend fun getAllFixtures() : Flow<Resource<FixtureRootModel>>
            = remoteDataSource.getAllFixtures()



}