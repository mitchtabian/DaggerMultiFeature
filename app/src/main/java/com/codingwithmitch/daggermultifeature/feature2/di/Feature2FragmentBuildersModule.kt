package com.codingwithmitch.daggermultifeature.feature2.di

import androidx.fragment.app.Fragment
import com.codingwithmitch.daggermultifeature.app.di.keys.FragmentKey
import com.codingwithmitch.daggermultifeature.feature2.ui.Feature2MainFragment
import com.codingwithmitch.daggermultifeature.feature2.ui.Feature2NextFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class Feature2FragmentBuildersModule{

    @Binds
    @IntoMap
    @FragmentKey(Feature2MainFragment::class)
    abstract fun bindMainFragment(fragment: Feature2MainFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(Feature2NextFragment::class)
    abstract fun bindNextFragment(fragment: Feature2NextFragment): Fragment
}