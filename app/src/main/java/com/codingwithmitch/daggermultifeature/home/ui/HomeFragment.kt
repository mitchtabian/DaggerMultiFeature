package com.codingwithmitch.daggermultifeature.home.ui


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.codingwithmitch.daggermultifeature.app.ui.MainNavController

import com.codingwithmitch.daggermultifeature.R
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import com.codingwithmitch.daggermultifeature.app.ui.InjectingFragmentFactory
import com.codingwithmitch.daggermultifeature.app.viewmodels.ViewModelProviderFactory
import com.codingwithmitch.daggermultifeature.home.di.HomeInjectable
import com.codingwithmitch.daggermultifeature.home.di.HomeScope
import com.codingwithmitch.daggermultifeature.home.repository.HomeRepository
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject
import javax.inject.Named

@HomeScope
class HomeFragment
@Inject
constructor(
    private val viewModelFactory: ViewModelProviderFactory,
    private @Named("application_name") val applicationName: String
): Fragment(){

    private val TAG: String = "AppDebug"

    val viewModel: HomeViewModel by viewModels {
        viewModelFactory
    }

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

        subscribeObservers()
        initUI()
    }

    private fun subscribeObservers(){
        viewModel.homeString.observe(viewLifecycleOwner, Observer { homeString ->
            fragment_name.text = homeString
        })
    }

    private fun initUI(){
        mainNavController.setDrawerItemChecked(R.id.nav_home)
        home_header.text = applicationName
        viewModel.retrieveHomeString()
    }

    override fun onAttach(context: Context) {
//        ((activity?.application) as BaseApplication)
//            .getAppComponent()
//            .homeComponent()
//            .create()
//            .inject(this)
        super.onAttach(context)
        try{
            mainNavController = context as MainNavController
        }catch(e: ClassCastException){
            Log.e(TAG, "$context must implement MainNavController" )
        }
    }

}
















