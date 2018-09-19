package com.sniped.ui.main.di

import com.sniped.di.ActivityScope
import com.sniped.di.AppComponent
import com.sniped.ui.main.MainPresenter
import com.sniped.ui.navigator.NavigatorModule
import dagger.Component

@ActivityScope
@Component(
        dependencies = [AppComponent::class],
        modules = [MainModule::class, NavigatorModule::class])
interface MainComponent {

    fun presenter(): MainPresenter
}
