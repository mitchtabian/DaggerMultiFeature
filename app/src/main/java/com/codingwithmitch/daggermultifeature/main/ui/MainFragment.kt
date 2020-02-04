package com.codingwithmitch.daggermultifeature.main.ui


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import com.codingwithmitch.daggermultifeature.R
import com.codingwithmitch.daggermultifeature.app.ui.MainNavController
import com.codingwithmitch.daggermultifeature.main.viewmodels.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject
import javax.inject.Named

class MainFragment
@Inject
constructor(
    private val viewModelFactory: MainViewModelFactory,
    private @Named("application_name") val applicationName: String
): Fragment(R.layout.fragment_main){

    private val TAG: String = "AppDebug"

    val viewModel: MainViewModel by viewModels {
        viewModelFactory
    }

    lateinit var mainNavController: MainNavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_go_feature1.setOnClickListener {
            mainNavController.navFeature1()
        }

        subscribeObservers()
        initUI()
    }

    private fun subscribeObservers(){
        viewModel.homeString.observe(viewLifecycleOwner, Observer { homeString ->
            fragment_name.text = homeString
        })
    }

    private fun initUI(){
        mainNavController.setDrawerItemChecked(R.id.nav_main)
        main_header.text = applicationName
        viewModel.retrieveHomeString()
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
















