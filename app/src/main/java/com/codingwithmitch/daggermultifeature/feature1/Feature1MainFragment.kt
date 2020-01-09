package com.codingwithmitch.daggermultifeature.feature1


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.codingwithmitch.daggermultifeature.MainNavController

import com.codingwithmitch.daggermultifeature.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_feature1_main.*

class Feature1MainFragment : Fragment() {

    private val TAG: String = "AppDebug"

    lateinit var mainNavController: MainNavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feature1_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_go_next.setOnClickListener {
            findNavController().navigate(R.id.action_feature1MainFragment_to_feature1NextFragment)
        }

        mainNavController.setDrawerItemChecked(R.id.nav_feature1)
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
