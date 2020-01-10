package com.codingwithmitch.daggermultifeature.app.di

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule{

    @Module
    companion object{

        @Singleton
        @Provides
        @Named("application_name")
        @JvmStatic
        fun provideApplicationName(): String {
            return "Dagger Multi-feature Demo"
        }
    }

}

