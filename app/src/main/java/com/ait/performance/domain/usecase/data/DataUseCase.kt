package com.ait.performance.domain.usecase.data

import com.ait.performance.domain.repository.DataRepository
import com.ait.performance.domain.usecase.BaseUseCase
import com.ait.performance.utils.DomainResult
import javax.inject.Inject

class DataUseCase @Inject constructor(
    private val dataRepository: DataRepository,
): BaseUseCase<Unit, List<String>>() {

    override suspend fun build(param: Unit): DomainResult<List<String>> {
        return dataRepository.loadData()
    }

}