package com.epicadk.zipline.sample

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow

interface Greeter {
    val input: Channel<String>
    val output: StateFlow<String>
}