package com.codingwithmitch.daggermultifeature.feature1.ui


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.codingwithmitch.daggermultifeature.app.ui.MainNavController

import com.codingwithmitch.daggermultifeature.R
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import com.codingwithmitch.daggermultifeature.feature1.di.Feature1FragmentScope
import com.codingwithmitch.daggermultifeature.feature1.viewmodels.Feature1ViewModelFactory
import kotlinx.android.synthetic.main.fragment_feature1_main.*
import kotlinx.android.synthetic.main.fragment_feature1_main.fragment_name
import kotlinx.android.synthetic.main.fragment_feature1_next.*
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

        btn_go_final.setOnClickListener {
            findNavController().navigate(R.id.action_feature1NextFragment_to_feature1FinalFragment)
        }
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
        ((activity?.application) as BaseApplication)
            .getAppComponent()
            .feature1Component()
            .create()
            .inject(this)
        super.onAttach(context)
        try{
            mainNavController = context as MainNavController
        }catch(e: ClassCastException){
            Log.e(TAG, "$context must implement MainNavController" )
        }
    }

}
