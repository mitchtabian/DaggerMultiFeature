package com.codingwithmitch.daggermultifeature.app.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import javax.inject.Inject
import javax.inject.Provider

/**
 * From: https://github.com/zawadz88/NavigationComponentPlayground/blob/master/app/src/main/java/com/github/zawadz88/navigationcomponentplayground/di/factory/InjectingFragmentFactory.kt
 */
class InjectingNavHostFragment
@Inject
constructor() : NavHostFragment() {

    private val TAG: String = "AppDebug"

    @Inject
    protected lateinit var fragmentFactory: FragmentFactory

    @Inject
    protected lateinit var creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "NavHostFragment: $fragmentFactory")
        childFragmentManager.fragmentFactory = fragmentFactory
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        val appComponent = ((activity?.application) as BaseApplication)
            .getAppComponent()

        appComponent.inject(this)

        // DEBUG
        // check map for viewmodels
        for(viewmodel in creators.entries){
            Log.d(TAG, "ViewModel Map: ${viewmodel.value.get().javaClass.name}")
        }
        super.onAttach(context)
    }

}















