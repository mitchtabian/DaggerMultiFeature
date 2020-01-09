package com.codingwithmitch.daggermultifeature

import androidx.annotation.IdRes

interface MainNavController {

    fun navFeature1()

    fun navFeature2()

    fun navHome()

    fun setDrawerItemChecked(@IdRes menuItemId: Int)
}