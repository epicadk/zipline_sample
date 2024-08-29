package com.epicadk.zipline.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.cash.zipline.loader.ZiplineHttpClient
import kotlinx.coroutines.channels.Channel

class GreetingViewModel : ViewModel() {
    private lateinit var ziplineHttpClient: ZiplineHttpClient
    private val inputChannel = Channel<String>()

    val greeter: Greeter by lazy {
        GreetingLoader(
            viewModelScope,
            SingleThreadedCoroutineDispatcher(),
            ziplineHttpClient,
            inputChannel
        )
    }
}