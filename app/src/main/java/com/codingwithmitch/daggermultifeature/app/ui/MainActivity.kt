package com.codingwithmitch.daggermultifeature.app.ui

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.codingwithmitch.daggermultifeature.R
import com.codingwithmitch.daggermultifeature.feature1.fragments.Feature1FragmentFactory
import com.codingwithmitch.daggermultifeature.feature1.fragments.Feature1NavHostFragment
import com.codingwithmitch.daggermultifeature.main.fragments.MainFragmentFactory
import com.codingwithmitch.daggermultifeature.main.fragments.MainNavHostFragment
import com.codingwithmitch.daggermultifeature.main.ui.MainFragment
import com.google.android.material.navigation.NavigationView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity(),
    MainNavController,
    NavigationView.OnNavigationItemSelectedListener
{

    private val TAG: String = "AppDebug"

    private val navigationView: NavigationView by lazy {
        findViewById<NavigationView>(R.id.nav_view)
    }

    private lateinit var navController: NavController

    private fun createNavHost(@NavigationRes graphId: Int, fragmentFactoryName: String){

        val newNavHostFragment = when(fragmentFactoryName){

            MainFragmentFactory.FRAGMENT_FACTORY_NAME -> {
                MainNavHostFragment.create(
                    graphId
                )
            }

            Feature1FragmentFactory.FRAGMENT_FACTORY_NAME ->{
                Feature1NavHostFragment.create(
                    graphId
                )
            }

            else ->{
                MainNavHostFragment.create(
                    graphId
                )
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_nav_host_container,
                newNavHostFragment,
                getString(R.string.NavHostFragmentTag)
            )
            .setPrimaryNavigationFragment(newNavHostFragment)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navMain()
    }

    override fun navFeature1() {
        createNavHost(
            R.navigation.feature1_nav_graph,
            Feature1FragmentFactory.FRAGMENT_FACTORY_NAME
        )
        setDrawerItemChecked(R.id.nav_feature1)
    }

    override fun navMain() {
        createNavHost(
            R.navigation.main_nav_graph,
            MainFragmentFactory.FRAGMENT_FACTORY_NAME
        )
        setDrawerItemChecked(R.id.nav_main)
    }

    override fun onBackPressed() {
        if(drawer_layout.isDrawerOpen(Gravity.LEFT)){
            drawer_layout.closeDrawer(Gravity.LEFT)
        }
        else{
            // must exit from MainFragment
            if(getBackStackCount() < 1){
                if(!isMainFragmentInView()){
                    navMain()
                    return
                }
            }
            super.onBackPressed()
        }
    }

    private fun isMainFragmentInView(): Boolean {
        val navHostFragment = supportFragmentManager
            .findFragmentByTag(getString(R.string.NavHostFragmentTag)) as NavHostFragment
        val topFragment = navHostFragment.childFragmentManager.fragments[0]
        if(topFragment is MainFragment){
            return true
        }
        return false
    }

    private fun getBackStackCount(): Int{
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_nav_host_container)
        navHostFragment?.let { host ->
            host.childFragmentManager.let { fm ->
                return fm.backStackEntryCount
            }
        }
        return 0
    }

    override fun setDrawerItemChecked(@IdRes menuItemId: Int) {
        when(menuItemId){

            R.id.nav_main -> navigationView.menu.getItem(0).isChecked = true

            R.id.nav_feature1 -> navigationView.menu.getItem(1).isChecked = true
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.nav_main -> {
                navMain()
            }

            R.id.nav_feature1 -> {
                navFeature1()
            }

        }
        drawer_layout.closeDrawer(Gravity.LEFT)
        return true
    }

    override fun navController() = navController

    override fun setNavController(navController: NavController){
        this.navController = navController
    }

    override fun setupNavDrawer(){
        navigationView.setupWithNavController(navController)
        navigationView.setNavigationItemSelectedListener(this)
    }
}













