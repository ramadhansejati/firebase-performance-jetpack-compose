package com.ait.performance.data.repository

import com.ait.performance.domain.repository.DataRepository
import com.ait.performance.utils.DomainResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepositoryImpl @Inject constructor(
) : DataRepository {

    override suspend fun loadData(): DomainResult<List<String>> {
        return DomainResult.Success(listOf())
    }
}