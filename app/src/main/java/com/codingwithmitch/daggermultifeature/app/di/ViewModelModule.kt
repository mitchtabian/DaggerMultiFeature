package com.codingwithmitch.daggermultifeature.app.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.daggermultifeature.app.di.keys.ViewModelKey
import com.codingwithmitch.daggermultifeature.app.ui.MainViewModel
import com.codingwithmitch.daggermultifeature.app.viewmodels.ViewModelProviderFactory
import com.codingwithmitch.daggermultifeature.feature1.di.Feature1Scope
import com.codingwithmitch.daggermultifeature.feature1.ui.Feature1ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule{

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}