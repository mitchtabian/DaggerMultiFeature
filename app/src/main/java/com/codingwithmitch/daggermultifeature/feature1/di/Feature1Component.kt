package com.codingwithmitch.daggermultifeature.feature1.di

import com.codingwithmitch.daggermultifeature.app.ui.InjectingNavHostFragment
import dagger.Subcomponent

@Feature1Scope
@Subcomponent(modules = [
    Feature1Module::class,
    Feature1ViewModelModule::class,
    Feature1FragmentFactoryModule::class
])
interface Feature1Component {

    @Subcomponent.Builder
    interface Builder{

        fun create(): Feature1Component
    }

    fun inject(navHostFragment: InjectingNavHostFragment)

}




