package com.codingwithmitch.daggermultifeature.app.di

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule{

    @Singleton
    @Provides
    @Named("application_name")
    fun provideApplicationName(): String {
        return "Dagger Multi-feature Demo"
    }
}

