package com.codingwithmitch.daggermultifeature.feature1.di

import androidx.fragment.app.Fragment
import com.codingwithmitch.daggermultifeature.app.di.keys.FragmentKey
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1MainFragment
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1NextFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class Feature1FragmentBuildersModule {

//    @Binds
//    @IntoMap
//    @FragmentKey(Feature1MainFragment::class)
//    abstract fun bindFeature1MainFragment(fragment: Feature1MainFragment): Fragment
//
//    @Binds
//    @IntoMap
//    @FragmentKey(Feature1NextFragment::class)
//    abstract fun bindFeature1NextFragment(fragment: Feature1NextFragment): Fragment

}