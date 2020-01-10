package com.codingwithmitch.daggermultifeature.feature2.di

import androidx.lifecycle.ViewModel
import com.codingwithmitch.daggermultifeature.app.di.ViewModelKey
import com.codingwithmitch.daggermultifeature.feature2.ui.Feature2ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class Feature2ViewModelModule{

    @Binds
    @IntoMap
    @ViewModelKey(Feature2ViewModel::class)
    abstract fun bindFeature2ViewModel(feature2ViewModel: Feature2ViewModel): ViewModel

}