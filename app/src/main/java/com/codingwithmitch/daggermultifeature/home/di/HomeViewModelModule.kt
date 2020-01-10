package com.codingwithmitch.daggermultifeature.home.di

import androidx.lifecycle.ViewModel
import com.codingwithmitch.daggermultifeature.app.di.ViewModelKey
import com.codingwithmitch.daggermultifeature.home.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule{


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

}