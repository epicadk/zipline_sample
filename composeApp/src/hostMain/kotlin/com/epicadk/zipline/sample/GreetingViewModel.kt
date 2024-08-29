package com.epicadk.zipline.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class GreetingViewModel : ViewModel() {
    private val inputChannel = Channel<String>()

    private val greeter: Greeter by lazy {
        GreetingLoader(
            viewModelScope,
            SingleThreadedCoroutineDispatcher(),
            ziplineHttpClient,
            inputChannel
        )
    }

    init {
        viewModelScope.launch {
            for (x in 1..100) {
                inputChannel.send(x.toString())
                delay(1.seconds)
            }
        }
    }

    val outputFlow
        get() = greeter.output
}