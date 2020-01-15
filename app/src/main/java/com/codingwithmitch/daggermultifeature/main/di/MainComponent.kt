package com.codingwithmitch.daggermultifeature.main.di

import com.codingwithmitch.daggermultifeature.main.ui.MainFragment
import dagger.Subcomponent


@MainFragmentScope
@Subcomponent(
    modules = [
        ViewModelModule::class
    ]
)
interface MainComponent {

    @Subcomponent.Factory
    interface Factory{

        fun create(): MainComponent
    }

    fun inject(mainFragment: MainFragment)
}