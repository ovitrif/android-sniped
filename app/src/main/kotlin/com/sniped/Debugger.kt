package com.sniped

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import com.sniped.core.config.AppConfig.SERVER_LOGGING_LEVEL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object Debugger {

    private val networkPlugin = NetworkFlipperPlugin()

    fun attachToApp(app: Application) {
        SoLoader.init(app, false)

        if (FlipperUtils.shouldEnableFlipper(app)) {
            val client = AndroidFlipperClient.getInstance(app)
            client.addPlugin(InspectorFlipperPlugin(app, DescriptorMapping.withDefaults()))
            client.addPlugin(networkPlugin)
            client.start()
        }
    }

    fun attachToNetwork(okHttpClientBuilder: OkHttpClient.Builder) {
        okHttpClientBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(SERVER_LOGGING_LEVEL))
        okHttpClientBuilder.addNetworkInterceptor(FlipperOkhttpInterceptor(networkPlugin))
    }
}
