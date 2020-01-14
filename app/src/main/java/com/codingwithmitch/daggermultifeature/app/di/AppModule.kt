package com.codingwithmitch.daggermultifeature.app.di

import com.codingwithmitch.daggermultifeature.app.repository.MainRepository
import com.codingwithmitch.daggermultifeature.app.repository.MainRepositoryImpl
import com.codingwithmitch.daggermultifeature.app.data.MainLocalDataSource
import com.codingwithmitch.daggermultifeature.app.data.MainLocalDataSourceImpl
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

        @Singleton
        @Provides
        @JvmStatic
        fun provideMainLocalDataSource(): MainLocalDataSource {
            return MainLocalDataSourceImpl()
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideMainRepository(localDataSource: MainLocalDataSource): MainRepository {
            return MainRepositoryImpl(localDataSource)
        }
    }

}

