package com.codingwithmitch.daggermultifeature.feature1.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import com.codingwithmitch.daggermultifeature.app.ui.MainNavController
import com.codingwithmitch.daggermultifeature.feature1.di.Feature1FragmentScope
import java.lang.ClassCastException
import javax.inject.Inject

@Feature1FragmentScope
class Feature1NavHostFragment
@Inject
constructor(
): NavHostFragment(){

    private val TAG: String = "AppDebug"

    lateinit var mainNavController: MainNavController

    @Inject
    lateinit var feature1FragmentFactory: Feature1FragmentFactory

    override fun onAttach(context: Context) {
        ((activity?.application) as BaseApplication)
            .getAppComponent()
            .feature1Component()
            .create()
            .inject(this)
        childFragmentManager.fragmentFactory = feature1FragmentFactory
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
        ): Feature1NavHostFragment{
            var bundle: Bundle? = null
            if(graphId != 0){
                bundle = Bundle()
                bundle.putInt(KEY_GRAPH_ID, graphId)
            }
            val result = Feature1NavHostFragment()
            if(bundle != null){
                result.arguments = bundle
            }
            return result
        }
    }

}








