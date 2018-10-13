package com.sniped.ui.main.di

import com.sniped.ui.main.IMain
import dagger.Module
import dagger.Provides

@Module
class MainModule(
        private val view: IMain.View) {

    @Provides
    fun provideView() = view
}
