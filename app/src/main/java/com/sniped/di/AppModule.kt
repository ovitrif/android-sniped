package com.sniped.di

import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sniped.R
import com.sniped.api.ApiService
import com.sniped.api.ApiServiceBuilder
import com.sniped.core.Threads
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Main application module for Dagger2.
 * Defines provider functions for the application singletons.
 */

@Module
open class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    open fun provideApiService(
            gson: Gson): ApiService {
        val apiUri = context.getString(R.string.api)
        val apiServiceBuilder = ApiServiceBuilder(
                apiUri,
                gson)

        return apiServiceBuilder
                .build()
                .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    fun provideThreads() = Threads(Handler(Looper.getMainLooper()))
}
