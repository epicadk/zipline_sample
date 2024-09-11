package com.epicadk.zipline.sample

import android.app.Application
import android.content.Context

object ContextProvider {
    lateinit var context: Context
        private set

    fun init(application: Application) {
        context = application
    }
}
