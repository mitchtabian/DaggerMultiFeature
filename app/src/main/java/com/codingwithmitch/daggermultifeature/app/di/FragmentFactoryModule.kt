package com.codingwithmitch.daggermultifeature.app.di

import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.NavHostFragment
import com.codingwithmitch.daggermultifeature.app.ui.InjectingFragmentFactory
import com.codingwithmitch.daggermultifeature.app.ui.InjectingNavHostFragment
import dagger.Binds
import dagger.Module

@Module
abstract class FragmentFactoryModule{

    @Binds
    abstract fun bindFragmentFactory(factory: InjectingFragmentFactory): FragmentFactory

    @Binds
    abstract fun bindInjectingNavHostFragment(factory: InjectingNavHostFragment): NavHostFragment

}