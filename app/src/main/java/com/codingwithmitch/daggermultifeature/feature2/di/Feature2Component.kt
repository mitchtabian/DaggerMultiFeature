package com.codingwithmitch.daggermultifeature.feature2.di

import com.codingwithmitch.daggermultifeature.feature2.ui.Feature2MainFragment
import com.codingwithmitch.daggermultifeature.feature2.ui.Feature2NextFragment
import dagger.Subcomponent

@Feature2Scope
@Subcomponent(modules = [Feature2Module::class, Feature2ViewModelModule::class])
interface Feature2Component {

    @Subcomponent.Factory
    interface Factory {
        fun create(): Feature2Component
    }

    fun inject(feature2MainFragment: Feature2MainFragment)

    fun inject(feature2NextFragment: Feature2NextFragment)

}