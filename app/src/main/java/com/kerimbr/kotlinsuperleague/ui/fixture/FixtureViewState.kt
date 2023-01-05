package com.kerimbr.kotlinsuperleague.ui.fixture

import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureRootModel

data class FixtureViewState(
    val isLoading: Boolean = false,
    val fixtures: FixtureRootModel? = null,
    val error: String? = null
)