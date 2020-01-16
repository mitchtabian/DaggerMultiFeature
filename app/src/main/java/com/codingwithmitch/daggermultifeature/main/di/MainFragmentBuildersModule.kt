package com.codingwithmitch.daggermultifeature.main.di

import androidx.fragment.app.Fragment
import com.codingwithmitch.daggermultifeature.main.di.keys.MainFragmentKey
import com.codingwithmitch.daggermultifeature.main.fragments.MainNavHostFragment
import com.codingwithmitch.daggermultifeature.main.ui.MainFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainFragmentBuildersModule {

    @Binds
    @IntoMap
    @MainFragmentKey(MainNavHostFragment::class)
    abstract fun bindNavHostFragment(mainNavHostFragment: MainNavHostFragment): Fragment

    @Binds
    @IntoMap
    @MainFragmentKey(MainFragment::class)
    abstract fun bindMainFragment(mainFragment: MainFragment): Fragment
}