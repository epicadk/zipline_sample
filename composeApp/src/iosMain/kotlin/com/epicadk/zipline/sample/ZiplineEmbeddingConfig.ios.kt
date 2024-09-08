package com.epicadk.zipline.sample

import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import platform.Foundation.NSBundle

actual class ZiplineEmbeddingConfig {
    actual val embeddingDir: Path = NSBundle.mainBundle.bundlePath.toPath()
    actual val embeddedFileSystem: FileSystem = FileSystem.SYSTEM
}