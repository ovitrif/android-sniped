package com.sniped.ui.main.detail.di

import com.sniped.ui.main.detail.IDetail
import dagger.Module
import dagger.Provides

@Module
class DetailModule(
        private val view: IDetail.View) {

    @Provides
    fun provideView() = view
}
