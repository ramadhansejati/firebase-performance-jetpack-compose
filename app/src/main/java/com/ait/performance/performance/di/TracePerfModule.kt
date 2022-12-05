package com.ait.performance.performance.di

import com.ait.performance.performance.ITracePerf
import com.ait.performance.performance.TracePerfImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TracePerfModule {

    @Binds
    @Singleton
    abstract fun bindTracePerf(
        tracePerfImpl: TracePerfImpl
    ): ITracePerf
}