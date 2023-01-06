package com.kerimbr.kotlinsuperleague.data.remote.service

import com.kerimbr.kotlinsuperleague.core.FIXTURE_MAX_ITEM_SIZE
import com.kerimbr.kotlinsuperleague.core.LEAGUE_ID
import com.kerimbr.kotlinsuperleague.core.LEAGUE_SEASONS
import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureRootModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballAPIService {

    @GET("/fixtures")
    suspend fun getAllFixtures(
        @Query("league") league: Int = LEAGUE_ID,
        @Query("season") season: Int = LEAGUE_SEASONS.last()
    ) : Response<FixtureRootModel>

    @GET("/fixtures")
    suspend fun getNextFixtures(
        @Query("league") league: Int = LEAGUE_ID,
        @Query("season") season: Int = LEAGUE_SEASONS.last(),
        @Query("next") next: Int = FIXTURE_MAX_ITEM_SIZE
    ) : Response<FixtureRootModel>

    @GET("/fixtures")
    suspend fun getLastFixtures(
        @Query("league") league: Int = LEAGUE_ID,
        @Query("season") season: Int = LEAGUE_SEASONS.last(),
        @Query("last") previous: Int = FIXTURE_MAX_ITEM_SIZE
    ) : Response<FixtureRootModel>

}