package com.epicadk.zipline.sample

import app.cash.zipline.loader.ZiplineHttpClient
import app.cash.zipline.loader.asZiplineHttpClient
import platform.Foundation.NSURLSession

actual val ziplineHttpClient: ZiplineHttpClient = NSURLSession.sharedSession.asZiplineHttpClient()
