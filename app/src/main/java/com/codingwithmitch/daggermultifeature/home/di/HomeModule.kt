package com.codingwithmitch.daggermultifeature.home.di

import com.codingwithmitch.daggermultifeature.home.data.HomeLocalDataSource
import com.codingwithmitch.daggermultifeature.home.data.HomeLocalDataSourceImpl
import com.codingwithmitch.daggermultifeature.home.repository.HomeRepository
import com.codingwithmitch.daggermultifeature.home.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Module
    companion object{

        @HomeScope
        @Provides
        @JvmStatic
        fun provideHomeLocalDataSource(): HomeLocalDataSource {
            return HomeLocalDataSourceImpl()
        }

        @HomeScope
        @Provides
        @JvmStatic
        fun provideHomeRepository(homeLocalDataSource: HomeLocalDataSource): HomeRepository {
            return HomeRepositoryImpl(homeLocalDataSource)
        }
    }

}


