package com.codingwithmitch.daggermultifeature.app.di

import android.app.Application
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import com.codingwithmitch.daggermultifeature.feature1.di.Feature1Component
import com.codingwithmitch.daggermultifeature.feature2.di.Feature2Component
import com.codingwithmitch.daggermultifeature.home.di.HomeComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ViewModelModule::class,
    SubcomponentsModule::class
])
interface AppComponent{

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: BaseApplication)

    fun homeComponent(): HomeComponent.Factory

    fun feature1Component(): Feature1Component.Factory

    fun feature2Component(): Feature2Component.Factory
}










