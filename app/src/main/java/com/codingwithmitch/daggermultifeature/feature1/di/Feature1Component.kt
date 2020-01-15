package com.codingwithmitch.daggermultifeature.feature1.di

import com.codingwithmitch.daggermultifeature.app.ui.MainActivity
import com.codingwithmitch.daggermultifeature.feature1.fragments.Feature1FragmentFactory
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1MainFragment
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1NextFragment
import dagger.Subcomponent


@Feature1FragmentScope
@Subcomponent(
    modules = [
        Feature1Module::class,
        Feature1ViewModelsModule::class,
        Feature1FragmentBuildersModule::class
    ]
)
interface Feature1Component {

    val fragmentFactory: Feature1FragmentFactory

    @Subcomponent.Factory
    interface Factory{

        fun create(): Feature1Component
    }

    fun inject(mainActivity: MainActivity)

    fun inject(feature1MainFragment: Feature1MainFragment)

    fun inject(feature1NextFragment: Feature1NextFragment)
}














