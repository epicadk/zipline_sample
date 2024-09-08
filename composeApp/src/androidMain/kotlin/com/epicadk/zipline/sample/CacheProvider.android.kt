package com.epicadk.zipline.sample

import android.content.Context
import app.cash.zipline.loader.ZiplineCache
import okio.FileSystem
import okio.Path.Companion.toOkioPath

actual class CacheProvider(context: Context) {
    actual val ziplineCache: ZiplineCache = ZiplineCache(
        context,
        FileSystem.SYSTEM,
        context.cacheDir.toOkioPath(),
        8 * 1024 * 1024
    )

}