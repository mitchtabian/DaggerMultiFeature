package com.codingwithmitch.daggermultifeature.main.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.codingwithmitch.daggermultifeature.main.di.keys.MainFragmentKey
import com.codingwithmitch.daggermultifeature.main.fragments.MainFragmentFactory
import com.codingwithmitch.daggermultifeature.main.fragments.MainNavHostFragment
import com.codingwithmitch.daggermultifeature.main.ui.MainFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainFragmentBuildersModule {

    @Binds
    abstract fun bindFragmentFactory(mainFragmentFactory: MainFragmentFactory): FragmentFactory

    @Binds
    @IntoMap
    @MainFragmentKey(MainFragment::class)
    abstract fun bindMainFragment(mainFragment: MainFragment): Fragment
}