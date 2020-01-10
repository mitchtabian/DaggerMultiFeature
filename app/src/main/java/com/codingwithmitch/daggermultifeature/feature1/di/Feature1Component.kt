package com.codingwithmitch.daggermultifeature.feature1.di

import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1MainFragment
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1NextFragment
import com.codingwithmitch.daggermultifeature.feature2.di.Feature2ViewModelModule
import dagger.Subcomponent

@Feature1Scope
@Subcomponent(modules = [Feature1Module::class, Feature1ViewModelModule::class])
interface Feature1Component {

    @Subcomponent.Factory
    interface Factory {
        fun create(): Feature1Component
    }

    fun inject(feature1MainFragment: Feature1MainFragment)

    fun inject(feature1NextFragment: Feature1NextFragment)

}