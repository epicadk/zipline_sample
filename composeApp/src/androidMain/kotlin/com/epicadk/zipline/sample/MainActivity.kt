package com.epicadk.zipline.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(CacheProvider(context = this))
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
//    App(CacheProvider(context = this))
}