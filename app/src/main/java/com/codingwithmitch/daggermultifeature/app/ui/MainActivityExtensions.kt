package com.codingwithmitch.daggermultifeature.app.ui

import android.util.Log
import com.codingwithmitch.daggermultifeature.feature1.fragments.Feature1FragmentFactory
import com.codingwithmitch.daggermultifeature.main.fragments.MainFragmentFactory

private val TAG: String = "AppDebug"


fun MainActivity.getMainFragmentFactory(): MainFragmentFactory {
    mainComponentManager
        .mainComponent
        .inject(this)
    return mainComponentManager.mainComponent.fragmentFactory
}

fun MainActivity.getFeature1FragmentFactory(): Feature1FragmentFactory{
    mainComponentManager
        .feature1Component
        .inject(this)
    return mainComponentManager.feature1Component.fragmentFactory
}







