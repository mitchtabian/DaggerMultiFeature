package com.codingwithmitch.daggermultifeature.feature1.di

import com.codingwithmitch.daggermultifeature.app.ui.InjectingNavHostFragment
import com.codingwithmitch.daggermultifeature.app.ui.MainFragment
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1MainFragment
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1NextFragment
import dagger.Subcomponent

@Feature1Scope
@Subcomponent(modules = [
    Feature1Module::class,
    Feature1ViewModelModule::class,
    Feature1FragmentFactoryModule::class
])
interface Feature1Component {

//    fun inject(mainFragment: MainFragment)

    fun inject(navHostFragment: InjectingNavHostFragment)

    fun inject(feature1MainFragment: Feature1MainFragment)

    fun inject(feature1NextFragment: Feature1NextFragment)

}