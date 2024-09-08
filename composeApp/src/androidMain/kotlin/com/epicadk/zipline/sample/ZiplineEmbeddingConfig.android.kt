package com.epicadk.zipline.sample

import android.content.Context
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import okio.assetfilesystem.asFileSystem

actual class ZiplineEmbeddingConfig(context: Context) {
    actual val embeddingDir: Path = "zipembed".toPath()
    actual val embeddedFileSystem: FileSystem = context.assets.asFileSystem()
}