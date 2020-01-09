package com.codingwithmitch.daggermultifeature.home


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.codingwithmitch.daggermultifeature.MainNavController

import com.codingwithmitch.daggermultifeature.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val TAG: String = "AppDebug"

    lateinit var mainNavController: MainNavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_go_feature1.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_feature1MainFragment)
        }

        btn_go_feature2.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_feature2MainFragment)
        }

        mainNavController.setDrawerItemChecked(R.id.nav_home)
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
















