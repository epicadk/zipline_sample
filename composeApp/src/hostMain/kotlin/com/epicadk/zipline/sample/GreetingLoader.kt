package com.epicadk.zipline.sample

import app.cash.zipline.EventListener
import app.cash.zipline.loader.DefaultFreshnessCheckerNotFresh
import app.cash.zipline.loader.LoadResult
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.ZiplineHttpClient
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class GreetingLoader(
    scope: CoroutineScope,
    ziplineDisPatcher: CoroutineDispatcher,
    ziplineHttpClient: ZiplineHttpClient,
    override val input: Channel<String>
) : Greeter {

    private val _output: MutableStateFlow<String> =
        MutableStateFlow("")

    override val output: StateFlow<String>
        get() = _output

    private val loadResult by lazy {
        ZiplineLoader(
            dispatcher = ziplineDisPatcher,
            manifestVerifier = ManifestVerifier.NO_SIGNATURE_CHECKS, // TODO create sample with manifest checks
            httpClient = ziplineHttpClient,
            eventListener = EventListener.NONE // TODO create sample with event listeners
        ).load(
            applicationName = "com.epicadk.zipline.sample.greeter",
            manifestUrlFlow = flowOf(""),
            freshnessChecker = DefaultFreshnessCheckerNotFresh
        )
    }

    init {
        scope.launch {
            loadResult.collect {
                when (it) {
                    is LoadResult.Failure -> {
                        // Log failure
                    }

                    is LoadResult.Success -> {
                        val greeterService = it.zipline.take<GreetingService>("GreetingService")
                        for (name in input) {
                            _output.emit(greeterService.greet(name))
                        }
                    }
                }
            }
        }
    }
}