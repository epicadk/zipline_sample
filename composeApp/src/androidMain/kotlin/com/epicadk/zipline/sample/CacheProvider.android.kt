package com.epicadk.zipline.sample

import app.cash.zipline.loader.ZiplineCache
import okio.FileSystem
import okio.Path.Companion.toOkioPath

actual class CacheProvider {
    actual val ziplineCache: ZiplineCache = ZiplineCache(
        ContextProvider.context,
        FileSystem.SYSTEM,
        ContextProvider.context.cacheDir.toOkioPath(),
        8 * 1024 * 1024,
    )
}
