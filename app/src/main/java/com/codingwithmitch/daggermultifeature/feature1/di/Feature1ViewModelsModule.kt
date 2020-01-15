package com.codingwithmitch.daggermultifeature.feature1.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.daggermultifeature.feature1.di.keys.Feature1ViewModelKey
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1ViewModel
import com.codingwithmitch.daggermultifeature.feature1.viewmodels.Feature1ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class Feature1ViewModelsModule{

    @Binds
    abstract fun bindFeature1VMFactory(factory: Feature1ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @Feature1ViewModelKey(Feature1ViewModel::class)
    abstract fun bindFeature1ViewModel(feature1ViewModel: Feature1ViewModel): ViewModel

}