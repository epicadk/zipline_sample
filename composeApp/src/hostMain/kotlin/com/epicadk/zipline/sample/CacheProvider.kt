package com.epicadk.zipline.sample

import app.cash.zipline.loader.ZiplineCache

expect class CacheProvider {
    val ziplineCache: ZiplineCache
}