package com.ait.performance.performance


class TracePerfImplFake: ITracePerf {

    override fun init(traceName: String) {
        // init
    }

    override fun start(attributes: List<Pair<String, String>>?) {
        // start
    }

    override fun stop(attributes: List<Pair<String, String>>?, isSuccess: Boolean) {
        // stop
    }

}