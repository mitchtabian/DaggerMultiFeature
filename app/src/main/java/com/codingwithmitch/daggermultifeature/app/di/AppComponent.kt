package com.codingwithmitch.daggermultifeature.app.di

import android.app.Application
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import com.codingwithmitch.daggermultifeature.feature1.di.Feature1Component
import com.codingwithmitch.daggermultifeature.main.di.MainComponent
import com.codingwithmitch.daggermultifeature.main.di.MainFragmentBuildersModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    SubComponentsModule::class
])
interface AppComponent{

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: BaseApplication)

    fun feature1Component(): Feature1Component.Factory

    fun mainComponent(): MainComponent.Factory

}









