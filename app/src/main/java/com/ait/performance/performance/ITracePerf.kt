package com.ait.performance.performance

interface ITracePerf {
    fun init(traceName: String)
    fun start(attributes: List<Pair<String, String>>? = null)
    fun stop(attributes: List<Pair<String, String>>? = null, isSuccess: Boolean)
}