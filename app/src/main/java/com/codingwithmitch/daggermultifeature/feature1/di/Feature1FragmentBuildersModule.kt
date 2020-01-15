package com.codingwithmitch.daggermultifeature.feature1.di

import androidx.fragment.app.Fragment
import com.codingwithmitch.daggermultifeature.feature1.di.keys.Feature1FragmentKey
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1MainFragment
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1NextFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class Feature1FragmentBuildersModule {

    @Binds
    @IntoMap
    @Feature1FragmentKey(Feature1MainFragment::class)
    abstract fun bindMainFragment(feature1MainFragment: Feature1MainFragment): Fragment

    @Binds
    @IntoMap
    @Feature1FragmentKey(Feature1NextFragment::class)
    abstract fun bindNextFragment(feature1NextFragment: Feature1NextFragment): Fragment
}