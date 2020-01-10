package com.codingwithmitch.daggermultifeature.home.di

import com.codingwithmitch.daggermultifeature.home.ui.HomeFragment
import dagger.Subcomponent

@HomeScope
@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    fun inject(homeFragment: HomeFragment)

}