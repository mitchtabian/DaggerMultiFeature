package com.codingwithmitch.daggermultifeature.app

import android.app.Application
import com.codingwithmitch.daggermultifeature.app.di.AppComponent
import com.codingwithmitch.daggermultifeature.app.di.DaggerAppComponent

class BaseApplication : Application() {

    private val appComponent = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    fun getAppComponent(): AppComponent{
        return appComponent
    }
}