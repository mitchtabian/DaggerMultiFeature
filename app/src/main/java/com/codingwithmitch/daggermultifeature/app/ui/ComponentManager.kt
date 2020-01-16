package com.codingwithmitch.daggermultifeature.app.ui

import com.codingwithmitch.daggermultifeature.app.BaseApplication
import com.codingwithmitch.daggermultifeature.feature1.di.Feature1Component
import com.codingwithmitch.daggermultifeature.main.di.MainComponent

class ComponentManager
constructor(
    activity: MainActivity
) {

    val mainComponent: MainComponent by lazy{
        ((activity.application) as BaseApplication)
            .getAppComponent()
            .mainComponent()
            .create()
    }

    val feature1Component: Feature1Component by lazy {
        ((activity.application) as BaseApplication)
            .getAppComponent()
            .feature1Component()
            .create()
    }


}














