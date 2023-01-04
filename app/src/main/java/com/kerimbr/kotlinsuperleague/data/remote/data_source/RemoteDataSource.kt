package com.kerimbr.kotlinsuperleague.data.remote.data_source

import com.kerimbr.kotlinsuperleague.data.remote.service.FootballAPIService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val footballAPIService: FootballAPIService
): BaseDataSource() {

    suspend fun getAllFixtures() = getResult { footballAPIService.getAllFixtures() }

}