package com.codingwithmitch.daggermultifeature.feature1.di

import androidx.fragment.app.Fragment
import com.codingwithmitch.daggermultifeature.app.di.keys.FragmentKey
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1MainFragment
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1NextFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class Feature1FragmentFactoryModule {

//    @Binds
//    @IntoMap
//    @FragmentKey(Feature1MainFragment::class)
//    abstract fun bindMainFragment(fragment: Feature1MainFragment): Fragment
//
//    @Binds
//    @IntoMap
//    @FragmentKey(Feature1NextFragment::class)
//    abstract fun bindNextFragment(fragment: Feature1NextFragment): Fragment
}
















