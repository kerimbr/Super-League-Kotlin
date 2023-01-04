package com.kerimbr.kotlinsuperleague.core

import okhttp3.internal.immutableListOf


const val CONNECT_TIMEOUT = 20L
const val READ_TIMEOUT = 60L
const val WRITE_TIMEOUT = 120L

const val BASE_URL = "https://v3.football.api-sports.io"

const val TIME_ZONE = "Europe/Istanbul"
const val LEAGUE_ID = 203
val LEAGUE_SEASONS = immutableListOf(2018, 2019, 2020, 2021, 2022)
