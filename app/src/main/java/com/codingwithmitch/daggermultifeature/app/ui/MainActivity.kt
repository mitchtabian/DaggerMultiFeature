package com.codingwithmitch.daggermultifeature.app.ui

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.codingwithmitch.daggermultifeature.R
import com.codingwithmitch.daggermultifeature.feature1.fragments.Feature1FragmentFactory
import com.codingwithmitch.daggermultifeature.main.fragments.MainFragmentFactory
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

    private val drawerNavOptions: NavOptions by lazy {
        NavOptions.Builder()
            .setPopUpTo(R.id.mainFragment, true)
            .build()
    }

    private val navigationView: NavigationView by lazy {
        findViewById<NavigationView>(R.id.nav_view)
    }

    val mainComponentManager: MainComponentManager by lazy {
        MainComponentManager(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        restoreFragmentFactory(savedInstanceState)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavDrawer()
    }

    private fun restoreFragmentFactory(savedInstanceState: Bundle?){
        savedInstanceState?.let{inState ->
            (inState[getString(R.string.bundle_key_fragment_factory)] as String?)
                ?.let{ factoryClassName ->
                    setFragmentFactory(factoryClassName)
                }?: setFragmentFactory(MainFragmentFactory.FRAGMENT_FACTORY_NAME)
        }?: setFragmentFactory(MainFragmentFactory.FRAGMENT_FACTORY_NAME)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val factoryName = getCurrentFragmentFactoryName(
            supportFragmentManager.fragmentFactory
        )
        outState.putString(getString(R.string.bundle_key_fragment_factory), factoryName)
        super.onSaveInstanceState(outState)
    }

    fun setFragmentFactory(factoryClassName: String){

        supportFragmentManager.fragmentFactory = when(factoryClassName){

            MainFragmentFactory.FRAGMENT_FACTORY_NAME -> {
                getMainFragmentFactory()
            }

            Feature1FragmentFactory.FRAGMENT_FACTORY_NAME -> {
                getFeature1FragmentFactory()
            }

            else ->{
                getMainFragmentFactory()
            }
        }
    }

    private fun setupNavDrawer(){
        navigationView.setupWithNavController(navController)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun navFeature1() {
        setFragmentFactory(Feature1FragmentFactory.FRAGMENT_FACTORY_NAME)
        navController.navigate(
            R.id.feature1MainFragment,
            null,
            null
        )
        setDrawerItemChecked(R.id.nav_feature1)
    }

    override fun navMain() {
        setFragmentFactory(MainFragmentFactory.FRAGMENT_FACTORY_NAME)
        navController.navigate(
            R.id.mainFragment,
            null,
            drawerNavOptions
        )
        setDrawerItemChecked(R.id.nav_main)
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


}













