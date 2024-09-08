package com.epicadk.zipline.sample

import okio.FileSystem
import okio.Path

expect class ZiplineEmbeddingConfig {
    val embeddingDir: Path
    val embeddedFileSystem: FileSystem
}
