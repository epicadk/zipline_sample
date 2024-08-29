package com.epicadk.zipline.sample

import app.cash.zipline.Zipline

val zipline by lazy { Zipline.get() }

@OptIn(ExperimentalJsExport::class)
@JsExport
fun main() {
    zipline.bind<GreetingService>("GreetingService", GreetingServiceImpl())
}

class GreetingServiceImpl : GreetingService {

    override fun greet(name: String): String {
        return "Hello $name"
    }
}