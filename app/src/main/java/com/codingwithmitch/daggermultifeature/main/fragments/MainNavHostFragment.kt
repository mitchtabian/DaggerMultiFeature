package com.codingwithmitch.daggermultifeature.main.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import com.codingwithmitch.daggermultifeature.app.ui.MainNavController
import com.codingwithmitch.daggermultifeature.main.di.MainFragmentScope
import java.lang.ClassCastException
import javax.inject.Inject

@MainFragmentScope
class MainNavHostFragment : NavHostFragment(){

    private val TAG: String = "AppDebug"

    lateinit var mainNavController: MainNavController

    @Inject
    lateinit var mainFragmentFactory: MainFragmentFactory

    override fun onAttach(context: Context) {
        ((activity?.application) as BaseApplication)
            .getAppComponent()
            .mainComponent()
            .create()
            .inject(this)

        childFragmentManager.fragmentFactory = mainFragmentFactory
        try{
            mainNavController = context as MainNavController
        }catch (e: ClassCastException){
            Log.e(TAG, "$context must implement MainNavController" )
        }
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainNavController.setNavController(this.navController)
        mainNavController.setupNavDrawer()
    }

    companion object{

        const val KEY_GRAPH_ID = "android-support-nav:fragment:graphId"

        @JvmStatic
        fun create(
            @NavigationRes graphId: Int = 0
        ): MainNavHostFragment {
            var bundle: Bundle? = null
            if(graphId != 0){
                bundle = Bundle()
                bundle.putInt(KEY_GRAPH_ID, graphId)
            }
            val result = MainNavHostFragment()
            if(bundle != null){
                result.arguments = bundle
            }
            return result
        }
    }
}








