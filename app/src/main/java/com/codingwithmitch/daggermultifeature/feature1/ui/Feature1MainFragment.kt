package com.codingwithmitch.daggermultifeature.feature1.ui


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.codingwithmitch.daggermultifeature.app.ui.MainNavController

import com.codingwithmitch.daggermultifeature.R
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import com.codingwithmitch.daggermultifeature.app.ui.ComponentManager
import com.codingwithmitch.daggermultifeature.app.ui.MainActivity
import com.codingwithmitch.daggermultifeature.feature1.di.Feature1FragmentScope
import com.codingwithmitch.daggermultifeature.feature1.fragments.Feature1FragmentFactory
import com.codingwithmitch.daggermultifeature.feature1.viewmodels.Feature1ViewModelFactory
import com.codingwithmitch.daggermultifeature.main.fragments.MainFragmentFactory
import kotlinx.android.synthetic.main.fragment_feature1_main.*
import javax.inject.Inject

//@Feature1FragmentScope
class Feature1MainFragment
@Inject
constructor(
    private val viewModelFactory: Feature1ViewModelFactory
): Fragment(R.layout.fragment_feature1_main) {

    private val TAG: String = "AppDebug"

    val viewModel: Feature1ViewModel by viewModels {
        viewModelFactory
    }

    lateinit var mainNavController: MainNavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_go_next.setOnClickListener {
            findNavController().navigate(R.id.action_feature1MainFragment_to_feature1NextFragment)
//            mainNavController.navController().navigate(R.id.action_feature1MainFragment_to_feature1NextFragment)
        }

        subscribeObservers()
        initUI()

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
        viewModel.feature1MainString.observe(viewLifecycleOwner, Observer { mainString ->
            fragment_name.text = mainString
        })
    }

    private fun initUI(){
        mainNavController.setDrawerItemChecked(R.id.nav_feature1)
        viewModel.retrieveMainString()
    }

    override fun onAttach(context: Context) {
        ((activity?.application) as BaseApplication)
            .getAppComponent()
            .feature1Component()
            .create()
            .inject(this)
        try{
            mainNavController = context as MainNavController
        }catch(e: ClassCastException){
            Log.e(TAG, "$context must implement MainNavController" )
        }
        super.onAttach(context)
    }
}
