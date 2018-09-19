package com.sniped.api

import com.google.gson.Gson
import com.sniped.BuildConfig
import com.sniped.core.config.AppConfig.SERVER_LOGGING_LEVEL
import com.sniped.core.config.AppConfig.SERVER_TIMEOUT_READ
import com.sniped.core.config.AppConfig.SERVER_TIMEOUT_WRITE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Retrofit2 service builder.
 * Includes configuration for server communication over network.
 */
class ApiServiceBuilder(
        private val apiUri: String,
        private val gson: Gson) {

    fun build(): Retrofit {
        val httpClient = OkHttpClient.Builder()

        httpClient.readTimeout(SERVER_TIMEOUT_READ, TimeUnit.SECONDS)
        httpClient.writeTimeout(SERVER_TIMEOUT_WRITE, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(SERVER_LOGGING_LEVEL))
        }

        return Retrofit.Builder().baseUrl(apiUri)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .validateEagerly(true)
                .client(httpClient.build())
                .build()
    }
}
