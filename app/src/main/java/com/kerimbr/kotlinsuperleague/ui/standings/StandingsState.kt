package com.kerimbr.kotlinsuperleague.ui.standings

import com.kerimbr.kotlinsuperleague.data.dto.standings.Standing
import com.kerimbr.kotlinsuperleague.data.dto.standings.StandingsRootModel


data class StandingsState (
    val isLoading: Boolean = false,
    val standingsRootModel: StandingsRootModel? = null,
    val standings: List<Standing>? = null,
    val error: String? = null
)