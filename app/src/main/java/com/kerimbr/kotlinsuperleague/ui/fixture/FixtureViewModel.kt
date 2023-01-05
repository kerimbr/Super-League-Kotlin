package com.kerimbr.kotlinsuperleague.ui.fixture

import androidx.lifecycle.viewModelScope
import com.kerimbr.kotlinsuperleague.data.DataRepository
import com.kerimbr.kotlinsuperleague.data.Resource
import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureRootModel
import com.kerimbr.kotlinsuperleague.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixtureViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : BaseViewModel() {

    private val _fixtureViewState = MutableStateFlow<FixtureViewState>(FixtureViewState())
    val fixtureViewState: StateFlow<FixtureViewState> = _fixtureViewState

    fun getAllFixtures() {
        if (_fixtureViewState.value.isLoading) return


        if (_fixtureViewState.value.fixtures == null) {
            viewModelScope.launch {
                dataRepository.getAllFixtures().collect {
                    when (it) {
                        is Resource.Success -> {
                            _fixtureViewState.value = FixtureViewState(
                                fixtures = it.data
                            )
                        }
                        is Resource.Error -> {
                            _fixtureViewState.value = FixtureViewState(
                                error = it.errorCode.toString()
                            )
                        }
                        is Resource.Loading -> {
                            _fixtureViewState.value = FixtureViewState(
                                isLoading = true
                            )
                        }
                    }
                }
            }
        }

    }


}
