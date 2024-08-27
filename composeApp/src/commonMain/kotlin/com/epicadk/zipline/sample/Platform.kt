package com.epicadk.zipline.sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform