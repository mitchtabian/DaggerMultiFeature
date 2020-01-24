package com.codingwithmitch.daggermultifeature.main.di

import com.codingwithmitch.daggermultifeature.main.data.MainLocalDataSource
import com.codingwithmitch.daggermultifeature.main.data.MainLocalDataSourceImpl
import com.codingwithmitch.daggermultifeature.main.repository.MainRepository
import com.codingwithmitch.daggermultifeature.main.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
object MainModule {

    @MainFragmentScope
    @Provides
    @JvmStatic
    fun provideMainLocalDataSource(): MainLocalDataSource {
        return MainLocalDataSourceImpl()
    }

    @MainFragmentScope
    @Provides
    @JvmStatic
    fun provideMainRepository(localDataSource: MainLocalDataSource): MainRepository {
        return MainRepositoryImpl(
            localDataSource
        )
    }
}