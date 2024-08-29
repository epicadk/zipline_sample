package com.epicadk.zipline.sample

import app.cash.zipline.loader.ZiplineHttpClient
import app.cash.zipline.loader.asZiplineHttpClient
import okhttp3.OkHttpClient

actual val ziplineHttpClient: ZiplineHttpClient =
    OkHttpClient.Builder().build().asZiplineHttpClient()