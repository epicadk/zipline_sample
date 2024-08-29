// source : https://github.com/cashapp/redwood/blob/trunk/redwood-treehouse-host/src/iosMain/kotlin/app/cash/redwood/treehouse/IosTreehouseDispatchers.kt
// license : https://github.com/cashapp/redwood/blob/trunk/LICENSE.txt

package com.epicadk.zipline.sample

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.convert
import kotlinx.coroutines.CloseableCoroutineDispatcher
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ClosedReceiveChannelException
import kotlinx.coroutines.runBlocking
import platform.Foundation.NSThread
import kotlin.coroutines.CoroutineContext

actual class SingleThreadedCoroutineDispatcher :
    CloseableCoroutineDispatcher() {
    private val channel = Channel<Runnable>(capacity = Channel.UNLIMITED)

    @OptIn(ExperimentalForeignApi::class)
    internal val thread = NSThread {
        runBlocking {
            while (true) {
                try {
                    val runnable = channel.receive()
                    // TODO(jwilson): handle uncaught exceptions.
                    runnable.run()
                } catch (e: ClosedReceiveChannelException) {
                    break
                }
            }
        }
    }.apply {
        this.name = "Zipline"

        this.stackSize = (8 * 1024 * 1024).convert()

        start()
    }

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        channel.trySend(block)
    }

    override fun close() {
        channel.close()
    }
}
