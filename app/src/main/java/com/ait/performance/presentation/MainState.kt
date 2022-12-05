package com.ait.performance.presentation

data class MainState(
    val listData: List<String> = listOf(),
    val error: String = ""
)