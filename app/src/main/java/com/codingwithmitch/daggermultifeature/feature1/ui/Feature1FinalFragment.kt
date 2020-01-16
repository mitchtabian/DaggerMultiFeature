package com.codingwithmitch.daggermultifeature.feature1.ui


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

import com.codingwithmitch.daggermultifeature.R
import javax.inject.Inject

class Feature1FinalFragment
@Inject
constructor(

): Fragment(R.layout.fragment_feature1_final) {

    private val TAG: String = "AppDebug"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        printBackstack()
    }

    fun printBackstack(){
        val navHostFragment = activity?.supportFragmentManager
            ?.findFragmentById(R.id.main_nav_host_container)
        Log.d(TAG, "Feature1: ${navHostFragment?.childFragmentManager?.fragments?.size}")

        val fragments: List<Fragment>? = navHostFragment?.childFragmentManager?.fragments
        if(fragments != null){
            for(fragment in fragments){
                Log.d(TAG, "Feature1: $fragment")
            }
        }

        val fs = (activity?.supportFragmentManager)?.fragments
        if(fs != null){
            for(f in fs){
                Log.d(TAG, "Feature1-fs: $f")
            }
        }
    }

}
