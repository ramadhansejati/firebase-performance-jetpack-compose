package com.ait.performance.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.ait.performance.performance.constants.TraceName
import com.google.firebase.perf.metrics.AddTrace

@Composable
@AddTrace(name = TraceName.screenMain)
fun MainScreen() {

    val viewModel: MainViewModel = hiltViewModel()

    LaunchedEffect(key1 = viewModel) {
        viewModel.event.collect { event ->
            when (event) {
                is MainEvent.OnDirectBack -> {

                }
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.onIntent(MainIntent.LoadData)
    }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (text) = createRefs()

        Text(
            text = "Hello World!",
            modifier = Modifier.constrainAs(text) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}

@Preview
@Composable
private fun Preview() {
    MainScreen()
}