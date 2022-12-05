package com.ait.performance.data.repository.fake

import com.ait.performance.domain.repository.DataRepository
import com.ait.performance.utils.DomainResult
import javax.inject.Inject

class DataRepositoryImplFakeSuccess @Inject constructor(
) : DataRepository {

    override suspend fun loadData(): DomainResult<List<String>> {
        return DomainResult.Success(listOf("Message"))
    }
}