package com.codingwithmitch.daggermultifeature.app.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.NavHostFragment
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import javax.inject.Inject

/**
 * From: https://github.com/zawadz88/NavigationComponentPlayground/blob/master/app/src/main/java/com/github/zawadz88/navigationcomponentplayground/di/factory/InjectingFragmentFactory.kt
 */
class InjectingNavHostFragment
@Inject
constructor() : NavHostFragment() {

    private val TAG: String = "AppDebug"

    @Inject
    protected lateinit var fragmentFactory: FragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "NavHostFragment: $fragmentFactory")
        childFragmentManager.fragmentFactory = fragmentFactory
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        ((activity?.application) as BaseApplication)
            .getAppComponent()
            .inject(this)
        super.onAttach(context)
    }

}















