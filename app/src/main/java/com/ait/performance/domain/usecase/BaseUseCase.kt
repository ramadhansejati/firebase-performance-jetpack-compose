package com.ait.performance.domain.usecase

import com.ait.performance.utils.DomainResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

abstract class BaseUseCase<in PARAM, RESULT : Any> {

    abstract suspend fun build(param: PARAM): DomainResult<RESULT>

    private suspend fun execute(param: PARAM): Flow<DomainResult<RESULT>> {
        return flow {
            emit(build(param))
        }.catch { error ->
            emit(
                DomainResult.Error(error.message.orEmpty())
            )
        }
    }

    suspend operator fun invoke(param: PARAM): Flow<DomainResult<RESULT>> = execute(param)

}