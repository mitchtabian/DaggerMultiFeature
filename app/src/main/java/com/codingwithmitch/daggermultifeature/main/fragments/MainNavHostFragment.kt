package com.codingwithmitch.daggermultifeature.main.fragments

import android.content.Context
import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import com.codingwithmitch.daggermultifeature.feature1.fragments.Feature1FragmentFactory
import com.codingwithmitch.daggermultifeature.feature1.fragments.Feature1NavHostFragment
import javax.inject.Inject

class MainNavHostFragment
@Inject
constructor(
    private val mainFragmentFactory: MainFragmentFactory
): NavHostFragment(){

    override fun onAttach(context: Context) {
        ((activity?.application) as BaseApplication)
            .getAppComponent()
            .mainComponent()
            .create()
            .inject(this)
        childFragmentManager.fragmentFactory = mainFragmentFactory
        super.onAttach(context)
    }

    companion object{

        const val KEY_GRAPH_ID = "android-support-nav:fragment:graphId"

        @JvmStatic
        fun create(
            mainFragmentFactory: MainFragmentFactory,
            @NavigationRes graphId: Int = 0
        ): MainNavHostFragment {
            var bundle: Bundle? = null
            if(graphId != 0){
                bundle = Bundle()
                bundle.putInt(KEY_GRAPH_ID, graphId)
            }
            val result = MainNavHostFragment(mainFragmentFactory)
            if(bundle != null){
                result.arguments = bundle
            }
            return result
        }
    }
}








