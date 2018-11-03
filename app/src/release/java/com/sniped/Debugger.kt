package com.sniped

import android.app.Application
import okhttp3.OkHttpClient

/**
 * Stub for debugging and logging handler.
 * Enables removal of debugging libraries from release builds.
 */
object Debugger {

    fun attachToApp(app: Application) = Unit

    fun attachToNetwork(okHttpClientBuilder: OkHttpClient.Builder) = Unit
}
