package com.epicadk.zipline.sample

import app.cash.zipline.Call
import app.cash.zipline.CallResult
import app.cash.zipline.EventListener
import app.cash.zipline.Zipline
import app.cash.zipline.ZiplineManifest
import app.cash.zipline.ZiplineService
import co.touchlab.kermit.Logger

class LoggingEventListener(private val logger: Logger) : EventListener() {

    override fun bindService(zipline: Zipline, name: String, service: ZiplineService) {
        logger.d { "bindService: zipline:$zipline, name:$name, service:$service" }
    }

    override fun takeService(zipline: Zipline, name: String, service: ZiplineService) {
        logger.d { "takeService: zipline:$zipline, name:$name, service:$service" }
    }

    override fun callStart(zipline: Zipline, call: Call): Any? {
        logger.d { "callStart: zipline:$zipline, call:$call" }
        return null
    }

    override fun callEnd(
        zipline: Zipline,
        call: Call,
        result: CallResult,
        startValue: Any?
    ) {
        logger.d { "callEnd: zipline:$zipline, call:$call, result:$result, startValue:$startValue" }
    }

    override fun serviceLeaked(zipline: Zipline, name: String) {
        logger.w { "serviceLeaked: zipline:$zipline, name:$name" }
    }

    override fun applicationLoadStart(applicationName: String, manifestUrl: String?): Any? {
        logger.d { "applicationLoadStart: applicationName:$applicationName, manifestUrl:$manifestUrl" }
        return null
    }

    override fun applicationLoadSkipped(
        applicationName: String,
        manifestUrl: String,
        startValue: Any?
    ) {
        logger.i { "applicationLoadSkipped: applicationName:$applicationName, manifestUrl:$manifestUrl, startValue:$startValue" }
    }

    override fun applicationLoadSkippedNotFresh(
        applicationName: String,
        manifestUrl: String?,
        startValue: Any?
    ) {
        logger.i { "applicationLoadSkippedNotFresh: applicationName:$applicationName, manifestUrl:$manifestUrl, startValue:$startValue" }
    }

    override fun applicationLoadSuccess(
        applicationName: String,
        manifestUrl: String?,
        manifest: ZiplineManifest,
        zipline: Zipline,
        startValue: Any?
    ) {
        logger.d { "applicationLoadSuccess: applicationName:$applicationName, manifestUrl:$manifestUrl, manifest:$manifest, zipline:$zipline, startValue:$startValue" }
    }

    override fun applicationLoadFailed(
        applicationName: String,
        manifestUrl: String?,
        exception: Exception,
        startValue: Any?
    ) {
        logger.e(exception) { "applicationLoadFailed: applicationName:$applicationName, manifestUrl:$manifestUrl, startValue:$startValue" }
    }

    override fun downloadStart(applicationName: String, url: String): Any? {
        logger.d { "downloadStart: applicationName:$applicationName, url:$url" }
        return null
    }

    override fun downloadEnd(applicationName: String, url: String, startValue: Any?) {
        logger.d { "downloadEnd: applicationName:$applicationName, url:$url, startValue:$startValue" }
    }

    override fun downloadFailed(
        applicationName: String,
        url: String,
        exception: Exception,
        startValue: Any?
    ) {
        logger.e(exception) { "downloadFailed: applicationName:$applicationName, url:$url, startValue:$startValue" }
    }

    override fun cacheHit(applicationName: String, url: String, fileSize: Long) {
        logger.i { "cacheHit: applicationName:$applicationName, url:$url, fileSize:$fileSize" }
    }

    override fun manifestParseFailed(
        applicationName: String,
        url: String?,
        exception: Exception
    ) {
        logger.e(exception) { "manifestParseFailed: applicationName:$applicationName, url:$url" }
    }

    override fun manifestVerified(
        applicationName: String,
        manifestUrl: String?,
        manifest: ZiplineManifest,
        verifiedKey: String
    ) {
        logger.d { "manifestVerified: applicationName:$applicationName, manifestUrl:$manifestUrl, manifest:$manifest, verifiedKey:$verifiedKey" }
    }

    override fun manifestReady(
        applicationName: String,
        manifestUrl: String?,
        manifest: ZiplineManifest
    ) {
        logger.d { "manifestReady: applicationName:$applicationName, manifestUrl:$manifestUrl, manifest:$manifest" }
    }

    override fun moduleLoadStart(zipline: Zipline, moduleId: String): Any? {
        logger.d { "moduleLoadStart: zipline:$zipline, moduleId:$moduleId" }
        return null
    }

    override fun moduleLoadEnd(zipline: Zipline, moduleId: String, startValue: Any?) {
        logger.d { "moduleLoadEnd: zipline:$zipline, moduleId:$moduleId, startValue:$startValue" }
    }

    override fun initializerStart(zipline: Zipline, applicationName: String): Any? {
        logger.d { "initializerStart: zipline:$zipline, applicationName:$applicationName" }
        return null
    }

    override fun initializerEnd(
        zipline: Zipline,
        applicationName: String,
        startValue: Any?
    ) {
        logger.d { "initializerEnd: zipline:$zipline, applicationName:$applicationName, startValue:$startValue" }
    }

    override fun mainFunctionStart(zipline: Zipline, applicationName: String): Any? {
        logger.d { "mainFunctionStart: zipline:$zipline, applicationName:$applicationName" }
        return null
    }

    override fun mainFunctionEnd(
        zipline: Zipline,
        applicationName: String,
        startValue: Any?
    ) {
        logger.d { "mainFunctionEnd: zipline:$zipline, applicationName:$applicationName, startValue:$startValue" }
    }

    override fun ziplineCreated(zipline: Zipline) {
        logger.d { "ziplineCreated: zipline:$zipline" }
    }

    override fun ziplineClosed(zipline: Zipline) {
        logger.d { "ziplineClosed: zipline:$zipline" }
    }
}
