package com.sniped

import android.app.Application
import okhttp3.OkHttpClient

interface Debugger {

    fun attachToApp(app: Application) = Unit

    fun attachToNetwork(okHttpClientBuilder: OkHttpClient.Builder) = Unit

    companion object {
        val NULL = object : Debugger {}
    }
}
