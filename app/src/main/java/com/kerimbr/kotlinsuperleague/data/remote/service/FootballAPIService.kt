package com.kerimbr.kotlinsuperleague.data.remote.service

import com.kerimbr.kotlinsuperleague.core.LEAGUE_ID
import com.kerimbr.kotlinsuperleague.core.LEAGUE_SEASONS
import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureRootModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballAPIService {

    @GET("/fixtures")
    suspend fun getAllLastFixtures(
        @Query("league") league: Int = LEAGUE_ID,
        @Query("season") season: Int = LEAGUE_SEASONS.last()
    ) : Response<FixtureRootModel>


}