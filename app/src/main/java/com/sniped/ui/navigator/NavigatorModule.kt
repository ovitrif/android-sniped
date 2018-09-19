package com.sniped.ui.navigator

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class NavigatorModule(private val activity: Activity) {

    @Provides
    fun provideActivity() = activity
}
