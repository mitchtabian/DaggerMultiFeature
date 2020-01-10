package com.codingwithmitch.daggermultifeature.app.di

import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.daggermultifeature.app.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule{

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}