package com.codingwithmitch.daggermultifeature.app.ui

import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

interface MainNavController {

    fun navController(): NavController

    fun setNavController(navController: NavController)

    fun setupNavDrawer()

    fun navFeature1()

    fun navMain()

    fun setDrawerItemChecked(@IdRes menuItemId: Int)
}