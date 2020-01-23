package com.codingwithmitch.daggermultifeature.main.di

import com.codingwithmitch.daggermultifeature.main.fragments.MainNavHostFragment
import com.codingwithmitch.daggermultifeature.main.ui.MainFragment
import dagger.Subcomponent


@MainFragmentScope
@Subcomponent(
    modules = [
        MainModule::class,
        ViewModelModule::class,
        MainFragmentBuildersModule::class
    ]
)
interface MainComponent {

    @Subcomponent.Factory
    interface Factory{

        fun create(): MainComponent
    }

    fun inject(mainNavHostFragment: MainNavHostFragment)

    fun inject(mainFragment: MainFragment)
}