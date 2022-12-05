package com.ait.performance.presentation

sealed class MainIntent {
    object LoadData: MainIntent()
    object BackPress: MainIntent()
}
