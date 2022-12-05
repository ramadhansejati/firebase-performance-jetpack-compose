package com.ait.performance.performance

import com.ait.performance.performance.attribute.AttributeName
import com.ait.performance.performance.attribute.AttributeValue
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TracePerfImpl @Inject constructor(): ITracePerf {
    private var tracePerf: TracePerf? = null
    private val pairSuccess = Pair(AttributeName.response, AttributeValue.success)
    private val pairFailed = Pair(AttributeName.response, AttributeValue.failed)

    override fun init(traceName: String) {
        // init trace
        tracePerf = TracePerf(traceName)
    }

    override fun start(attributes: List<Pair<String, String>>?) {
        // start stace
        tracePerf?.start(attributes)
    }

    override fun stop(attributes: List<Pair<String, String>>?, isSuccess: Boolean) {
        val listAttribute = mutableListOf<Pair<String, String>>()
        // validate status
        if (isSuccess) listAttribute.add(pairSuccess)
        else listAttribute.add(pairFailed)
        // add list custom
        attributes?.map { listAttribute.add(it) }
        // stop trace
        tracePerf?.stop(listAttribute)
    }
}