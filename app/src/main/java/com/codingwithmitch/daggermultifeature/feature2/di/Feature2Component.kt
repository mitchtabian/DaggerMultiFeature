package com.codingwithmitch.daggermultifeature.feature2.di

import com.codingwithmitch.daggermultifeature.app.ui.InjectingNavHostFragment
import dagger.Subcomponent

@Feature2Scope
@Subcomponent(modules = [
    Feature2Module::class,
    Feature2ViewModelModule::class,
    Feature2FragmentBuildersModule::class
])
interface Feature2Component {

    @Subcomponent.Builder
    interface Builder{

        fun create(): Feature2Component
    }

    fun inject(navHostFragment: InjectingNavHostFragment)

}