package com.codingwithmitch.daggermultifeature.feature1.di

import com.codingwithmitch.daggermultifeature.feature1.fragments.Feature1NavHostFragment
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1FinalFragment
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

    @Subcomponent.Factory
    interface Factory{

        fun create(): Feature1Component
    }

    fun inject(feature1NavHostFragment: Feature1NavHostFragment)

    fun inject(feature1MainFragment: Feature1MainFragment)

    fun inject(feature1NextFragment: Feature1NextFragment)

    fun inject(feature1FinalFragment: Feature1FinalFragment)
}














