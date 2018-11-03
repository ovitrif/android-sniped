package com.sniped

import android.app.Application
import okhttp3.OkHttpClient

object Debugger {

    fun attachToApp(app: Application) = Unit

    fun attachToNetwork(okHttpClientBuilder: OkHttpClient.Builder) = Unit
}
