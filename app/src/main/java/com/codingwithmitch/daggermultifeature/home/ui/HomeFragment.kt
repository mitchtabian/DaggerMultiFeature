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
import com.codingwithmitch.daggermultifeature.app.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject
import javax.inject.Named

class HomeFragment : Fragment() {

    private val TAG: String = "AppDebug"

    @Inject
    @Named("application_name")
    lateinit var applicationName: String

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    val viewModel: HomeViewModel by viewModels {
        viewModelFactory
    }

    lateinit var mainNavController: MainNavController

    override fun onCreate(savedInstanceState: Bundle?) {
        ((activity?.application) as BaseApplication)
            .getAppComponent()
            .homeComponent()
            .create()
            .inject(this)

        super.onCreate(savedInstanceState)
    }

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
        super.onAttach(context)
        try{
            mainNavController = context as MainNavController
        }catch(e: ClassCastException){
            Log.e(TAG, "$context must implement MainNavController" )
        }
    }

}
















