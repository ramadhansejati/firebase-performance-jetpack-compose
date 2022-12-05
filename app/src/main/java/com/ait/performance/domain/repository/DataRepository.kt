package com.ait.performance.domain.repository

import com.ait.performance.utils.DomainResult

interface DataRepository {

    suspend fun loadData(): DomainResult<List<String>>
}