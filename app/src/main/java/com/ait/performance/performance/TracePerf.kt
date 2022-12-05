package com.ait.performance.performance

import com.google.firebase.ktx.Firebase
import com.google.firebase.perf.ktx.performance
import com.google.firebase.perf.ktx.trace

class TracePerf(traceName: String) {
    private val trace = Firebase.performance.newTrace(traceName)

    fun start(attributes: List<Pair<String, String>>? = null) {
        if (attributes != null) {
            trace.trace {
                attributes.map {
                    putAttribute(it.first, it.second)
                }
            }
        }
        trace.start()
    }

    fun stop(attributes: List<Pair<String, String>>? = null) {
        if (attributes != null) {
            trace.trace {
                attributes.map {
                    putAttribute(it.first, it.second)
                }
            }
        }
        trace.stop()
    }
}