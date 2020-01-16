package com.codingwithmitch.daggermultifeature.app.ui

import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

interface MainNavController {

//    fun setFragmentFactory(factoryClassName: String)

//    fun navController(): NavController

    fun navFeature1()

    fun navMain()

    fun setDrawerItemChecked(@IdRes menuItemId: Int)
}