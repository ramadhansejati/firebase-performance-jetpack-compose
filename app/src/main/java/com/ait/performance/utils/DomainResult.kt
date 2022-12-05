package com.ait.performance.utils

sealed class DomainResult<out T : Any> {

    data class Success<T : Any>(
        val data: T
    ) : DomainResult<T>()

    data class Error(
        val messageResponse: String
    ) : DomainResult<Nothing>()
}