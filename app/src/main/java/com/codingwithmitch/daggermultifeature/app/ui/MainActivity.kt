package com.codingwithmitch.daggermultifeature.app.ui

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.codingwithmitch.daggermultifeature.R
import com.google.android.material.navigation.NavigationView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity(),
    MainNavController,
    NavigationView.OnNavigationItemSelectedListener
{

    private val TAG: String = "AppDebug"

    private val navController: NavController by lazy{
        findNavController(R.id.main_nav_host)
    }

    private val appBarConfiguration: AppBarConfiguration by lazy{
        AppBarConfiguration(navController.graph, drawer_layout)
    }

    private val drawerNavOptions: NavOptions by lazy {
        NavOptions.Builder()
            .setPopUpTo(R.id.homeFragment, false)
            .build()
    }

    private val navigationView: NavigationView by lazy {
        findViewById<NavigationView>(R.id.nav_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavDrawer()
    }

    private fun setupNavDrawer(){
        navigationView.setupWithNavController(navController)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun navFeature1() {
        navController.navigate(
            R.id.feature1MainFragment,
            null,
            drawerNavOptions
        )
    }

    override fun navFeature2() {
        navController.navigate(
            R.id.feature2MainFragment,
            null,
            drawerNavOptions)
    }

    override fun navHome() {
        navController.navigate(
            R.id.homeFragment,
            null,
            drawerNavOptions
        )
    }

    override fun onBackPressed() {
        if(drawer_layout.isDrawerOpen(Gravity.LEFT)){
            drawer_layout.closeDrawer(Gravity.LEFT)
        }
        else{
            super.onBackPressed()
        }
    }

    override fun setDrawerItemChecked(@IdRes menuItemId: Int) {
        when(menuItemId){

            R.id.nav_home -> navigationView.menu.getItem(0).isChecked = true

            R.id.nav_feature1 -> navigationView.menu.getItem(1).isChecked = true

            R.id.nav_feature2 -> navigationView.menu.getItem(2).isChecked = true
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.nav_home -> {
                navHome()
            }

            R.id.nav_feature1 -> {
                navFeature1()
            }

            R.id.nav_feature2 -> {
                navFeature2()
            }
        }
        drawer_layout.closeDrawer(Gravity.LEFT)
        return true
    }


}













