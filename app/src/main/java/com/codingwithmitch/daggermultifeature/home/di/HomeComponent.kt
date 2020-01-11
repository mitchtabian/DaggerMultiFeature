package com.codingwithmitch.daggermultifeature.home.di

import com.codingwithmitch.daggermultifeature.app.ui.InjectingNavHostFragment
import com.codingwithmitch.daggermultifeature.home.ui.HomeFragment
import dagger.Subcomponent

@HomeScope
@Subcomponent(modules = [
    HomeModule::class,
    HomeViewModelModule::class,
    HomeFragmentBuildersModule::class
])
interface HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    fun inject(fragment: InjectingNavHostFragment)

}