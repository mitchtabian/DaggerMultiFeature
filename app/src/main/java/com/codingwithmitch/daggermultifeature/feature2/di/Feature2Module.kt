package com.codingwithmitch.daggermultifeature.feature2.di

import com.codingwithmitch.daggermultifeature.feature1.data.Feature2LocalDataSource
import com.codingwithmitch.daggermultifeature.feature1.data.Feature2LocalDataSourceImpl
import com.codingwithmitch.daggermultifeature.feature2.repository.Feature2Repository
import com.codingwithmitch.daggermultifeature.feature2.repository.Feature2RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class Feature2Module {

    @Feature2Scope
    @Provides
    fun provideFeature2LocalDataSource(): Feature2LocalDataSource {
        return Feature2LocalDataSourceImpl()
    }

    @Feature2Scope
    @Provides
    fun provideFeature2Repository(feature2LocalDataSource: Feature2LocalDataSource): Feature2Repository {
        return Feature2RepositoryImpl(feature2LocalDataSource)
    }
}