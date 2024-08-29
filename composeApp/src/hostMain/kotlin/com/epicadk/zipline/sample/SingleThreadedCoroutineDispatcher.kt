package com.epicadk.zipline.sample

import kotlinx.coroutines.CloseableCoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
expect class SingleThreadedCoroutineDispatcher() : CloseableCoroutineDispatcher