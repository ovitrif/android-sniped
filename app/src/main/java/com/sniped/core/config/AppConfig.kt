package com.sniped.core.config

import com.sniped.BuildConfig

/**
 * Application configuration constants.
 */
object AppConfig {

    const val FILE_NAME_PREFS = BuildConfig.APPLICATION_ID
    const val SERVER_TIMEOUT_READ: Long = 30
    const val SERVER_TIMEOUT_WRITE: Long = 30
}
