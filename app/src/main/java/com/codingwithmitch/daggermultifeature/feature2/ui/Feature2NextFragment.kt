package com.codingwithmitch.daggermultifeature.feature2.ui


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.codingwithmitch.daggermultifeature.app.ui.MainNavController

import com.codingwithmitch.daggermultifeature.R
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import com.codingwithmitch.daggermultifeature.app.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_feature2_main.*
import javax.inject.Inject

class Feature2NextFragment : Fragment() {

    private val TAG: String = "AppDebug"

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    val viewModel: Feature2ViewModel by viewModels {
        viewModelFactory
    }

    lateinit var mainNavController: MainNavController

    override fun onCreate(savedInstanceState: Bundle?) {
        ((activity?.application) as BaseApplication)
            .getAppComponent()
            .feature2Component()
            .create()
            .inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feature2_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        initUI()
    }

    private fun subscribeObservers(){
        viewModel.feature2NextString.observe(viewLifecycleOwner, Observer { nextString ->
            fragment_name.text = nextString
        })
    }

    private fun initUI(){
        mainNavController.setDrawerItemChecked(R.id.nav_feature2)
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
