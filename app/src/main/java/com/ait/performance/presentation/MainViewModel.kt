package com.ait.performance.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ait.performance.domain.usecase.data.DataUseCase
import com.ait.performance.performance.ITracePerf
import com.ait.performance.performance.constants.TraceName
import com.ait.performance.utils.DomainResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val traceLoadDataApi: ITracePerf,
    private val dataUseCase: DataUseCase
) : ViewModel() {

    // UI state
    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state.asStateFlow()
    val currentState: MainState get() = state.value
    private fun setState(update: (old: MainState) -> MainState): MainState = _state.updateAndGet(update)
    // UI event
    private val eventChannel = Channel<MainEvent>()
    val event = eventChannel.receiveAsFlow()

    init {
        traceLoadDataApi.init(TraceName.apiLoadData)
    }

    fun onIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.BackPress ->
                doBackPress()
            is MainIntent.LoadData ->
                doLoadData()
        }
    }

    private fun doBackPress() = viewModelScope.launch {
        eventChannel.send(MainEvent.OnDirectBack)
    }

    private fun doLoadData() = viewModelScope.launch {
        traceLoadDataApi.start()

        dataUseCase.invoke(Unit)
            .onStart {  }
            .collect { result ->
                when (result) {
                    is DomainResult.Success -> {
                        traceLoadDataApi.stop(isSuccess = true)

                        setState { it.copy(listData = result.data) }
                    }
                    is DomainResult.Error -> {
                        traceLoadDataApi.stop(isSuccess = false)
                    }
                }
        }
    }
}