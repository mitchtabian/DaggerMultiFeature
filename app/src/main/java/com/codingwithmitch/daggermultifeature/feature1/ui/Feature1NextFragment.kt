package com.codingwithmitch.daggermultifeature.feature1.ui


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.codingwithmitch.daggermultifeature.app.ui.MainNavController

import com.codingwithmitch.daggermultifeature.R
import com.codingwithmitch.daggermultifeature.feature1.viewmodels.Feature1ViewModelFactory
import kotlinx.android.synthetic.main.fragment_feature1_main.*
import javax.inject.Inject

class Feature1NextFragment
@Inject
constructor(
    private val viewModelFactory: Feature1ViewModelFactory
): Fragment(R.layout.fragment_feature1_next) {

    private val TAG: String = "AppDebug"

    val viewModel: Feature1ViewModel by viewModels {
        viewModelFactory
    }

    lateinit var mainNavController: MainNavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        initUI()
    }

    private fun subscribeObservers(){
        viewModel.feature1NextString.observe(viewLifecycleOwner, Observer { nextString ->
            fragment_name.text = nextString
        })
    }

    private fun initUI(){
        mainNavController.setDrawerItemChecked(R.id.nav_feature1)
        viewModel.retrieveNextString()
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
