package com.codingwithmitch.daggermultifeature.feature2


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingwithmitch.daggermultifeature.MainNavController

import com.codingwithmitch.daggermultifeature.R

class Feature2NextFragment : Fragment() {

    private val TAG: String = "AppDebug"

    lateinit var mainNavController: MainNavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feature2_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainNavController.setDrawerItemChecked(R.id.nav_feature2)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            mainNavController = context as MainNavController
        }catch(e: ClassCastException){
            Log.e(TAG, "$context must implement MainNavController" )
        }
    }

}
