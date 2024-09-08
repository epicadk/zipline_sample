package com.epicadk.zipline.sample

import kotlinx.coroutines.CloseableCoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalCoroutinesApi::class)
actual class SingleThreadedCoroutineDispatcher : CloseableCoroutineDispatcher() {

    private val ziplineExecutorService = Executors.newSingleThreadExecutor { Thread(it, "Zipline") }
    private val ziplineDispatcher = ziplineExecutorService.asCoroutineDispatcher()

    override val executor: Executor
        get() = ziplineExecutorService

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        ziplineDispatcher.dispatch(context, block)
    }

    override fun close() {
        ziplineDispatcher.close()
    }
}
