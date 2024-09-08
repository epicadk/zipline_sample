package com.epicadk.zipline.sample

import app.cash.zipline.loader.ZiplineCache
import okio.FileSystem
import okio.Path.Companion.toPath
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask

actual class CacheProvider {
    actual val ziplineCache: ZiplineCache = ZiplineCache(
        fileSystem = FileSystem.SYSTEM,
        directory = (NSSearchPathForDirectoriesInDomains(
            directory = NSCachesDirectory,
            domainMask = NSUserDomainMask,
            expandTilde = true
        ).first() as String).toPath() / "zipline",
        maxSizeInBytes = 8 * 1024 * 1024
    )
}