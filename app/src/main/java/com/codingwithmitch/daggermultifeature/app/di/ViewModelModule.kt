package com.codingwithmitch.daggermultifeature.app.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.daggermultifeature.app.viewmodels.ViewModelProviderFactory
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1ViewModel
import com.codingwithmitch.daggermultifeature.feature2.ui.Feature2ViewModel
import com.codingwithmitch.daggermultifeature.home.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule{

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(Feature1ViewModel::class)
    abstract fun bindFeature1ViewModel(feature1ViewModel: Feature1ViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(Feature2ViewModel::class)
    abstract fun bindFeature2ViewModel(feature2ViewModel: Feature2ViewModel): ViewModel

}