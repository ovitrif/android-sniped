package com.sniped

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.sniped.di.AppComponent
import com.sniped.di.AppModule
import com.sniped.di.DaggerAppComponent

open class App : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        installMultiDex()
    }

    protected open fun installMultiDex() {
        MultiDex.install(this)
    }

    protected open fun init() {
        initDagger()
        attachDebugger()
    }

    private fun initDagger() {
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        component.inject(this)
    }

    private fun attachDebugger() {
        if (BuildConfig.DEBUG) Debugger.attachToApp(this)
    }

    companion object {
        lateinit var component: AppComponent
    }
}
