package com.codingwithmitch.daggermultifeature.home.ui

import androidx.fragment.app.FragmentFactory

class HomeFragmentFactory : FragmentFactory(){

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            HomeFragment::class.java.name -> {
                HomeFragment()
            }

            else -> super.instantiate(classLoader, className)
        }
}