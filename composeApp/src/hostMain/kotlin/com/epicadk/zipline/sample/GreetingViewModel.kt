package com.epicadk.zipline.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class GreetingViewModel(private val cacheProvider: CacheProvider) : ViewModel() {
    private val inputChannel = Channel<String>()

    private val greeter: Greeter by lazy {
        GreetingLoader(
            scope = viewModelScope,
            ziplineDisPatcher = SingleThreadedCoroutineDispatcher(),
            ziplineHttpClient = ziplineHttpClient,
            input = inputChannel,
            cache = cacheProvider.ziplineCache,
        )
    }

    init {
        viewModelScope.launch {
            repeat(100) { x ->
                inputChannel.send(x.toString())
                delay(1.seconds)
            }
        }
    }

    val outputFlow
        get() = greeter.output
}
