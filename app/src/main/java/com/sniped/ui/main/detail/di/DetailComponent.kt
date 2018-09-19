package com.sniped.ui.main.detail.di

import com.sniped.di.ActivityScope
import com.sniped.di.AppComponent
import com.sniped.ui.main.detail.DetailPresenter
import com.sniped.ui.navigator.NavigatorModule
import dagger.Component

@ActivityScope
@Component(
        dependencies = [AppComponent::class],
        modules = [DetailModule::class, NavigatorModule::class]
)
interface DetailComponent {

    fun presenter(): DetailPresenter
}
