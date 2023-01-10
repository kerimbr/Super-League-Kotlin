package com.kerimbr.kotlinsuperleague.ui.standings

import androidx.lifecycle.viewModelScope
import com.kerimbr.kotlinsuperleague.data.DataRepository
import com.kerimbr.kotlinsuperleague.data.Resource
import com.kerimbr.kotlinsuperleague.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : BaseViewModel() {

    private val _state = MutableStateFlow(StandingsState())
    val state : StateFlow<StandingsState> = _state

    fun getStandings() {
        if (_state.value.isLoading) return

        if (_state.value.standingsRootModel == null) {
            viewModelScope.launch {
                dataRepository.getStandings().collect {
                    when (it) {
                        is Resource.Success -> {
                            _state.value = StandingsState(
                                standingsRootModel = it.data,
                                standings = it.data?.standingsResponse
                                    ?.get(0)?.league?.standings?.get(0)
                            )
                        }
                        is Resource.Error -> {
                            _state.value = StandingsState(
                                error = it.errorCode.toString()
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = StandingsState(
                                isLoading = true
                            )
                        }
                    }
                }
            }
        }
    }

}