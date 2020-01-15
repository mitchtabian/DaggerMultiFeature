package com.codingwithmitch.daggermultifeature.feature1.di

import com.codingwithmitch.daggermultifeature.feature1.data.Feature1LocalDataSource
import com.codingwithmitch.daggermultifeature.feature1.data.Feature1LocalDataSourceImpl
import com.codingwithmitch.daggermultifeature.feature1.repository.Feature1Repository
import com.codingwithmitch.daggermultifeature.feature1.repository.Feature1RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class Feature1Module {

    @Module
    companion object{

        @Feature1FragmentScope
        @Provides
        @JvmStatic
        fun provideFeature1LocalDataSource(): Feature1LocalDataSource {
            return Feature1LocalDataSourceImpl()
        }

        @Feature1FragmentScope
        @Provides
        @JvmStatic
        fun provideFeature1Repository(
            feature1LocalDataSource: Feature1LocalDataSource
        ): Feature1Repository {
            return Feature1RepositoryImpl(feature1LocalDataSource)
        }
    }

}