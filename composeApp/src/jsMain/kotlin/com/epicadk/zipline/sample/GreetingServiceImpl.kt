package com.epicadk.zipline.sample

import app.cash.zipline.Zipline

val zipline by lazy { Zipline.get() }

@JsExport
fun main() {
    zipline.bind("GreetingService", GreetingServiceImpl())
}

class GreetingServiceImpl : GreetingService {

    override fun greet(name: String): String {
        return "Hello $name"
    }
}