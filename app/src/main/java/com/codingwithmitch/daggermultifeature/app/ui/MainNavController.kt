package com.codingwithmitch.daggermultifeature.app.ui

import androidx.annotation.IdRes

interface MainNavController {

    fun navFeature1()

    fun navMain()

    fun setDrawerItemChecked(@IdRes menuItemId: Int)
}