package com.ait.performance.presentation.success

import com.ait.performance.MainCoroutineRule
import com.ait.performance.data.repository.fake.DataRepositoryImplFakeSuccess
import com.ait.performance.domain.usecase.data.DataUseCase
import com.ait.performance.performance.TracePerfImplFake
import com.ait.performance.presentation.MainIntent
import com.ait.performance.presentation.MainViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelSuccessTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val dataRepositoryImpl by lazy { DataRepositoryImplFakeSuccess() }

    private val dataUseCase by lazy { DataUseCase(dataRepositoryImpl) }

    private lateinit var viewModel: MainViewModel


    @Before
    fun setUp() {
        // init view model
        viewModel = MainViewModel(
            traceLoadDataApi = TracePerfImplFake(),
            dataUseCase = dataUseCase
        )
    }

    @Test
    fun `Load data success`() {
        viewModel.onIntent(MainIntent.LoadData)

        coroutineRule.dispatcher.scheduler.advanceUntilIdle()

        assertThat(viewModel.currentState.listData.size == 1).isTrue()
    }
}