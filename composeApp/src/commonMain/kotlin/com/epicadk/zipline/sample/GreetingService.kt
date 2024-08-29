package com.epicadk.zipline.sample

import app.cash.zipline.ZiplineService

interface GreetingService : ZiplineService {
    fun greet(name: String): String
}