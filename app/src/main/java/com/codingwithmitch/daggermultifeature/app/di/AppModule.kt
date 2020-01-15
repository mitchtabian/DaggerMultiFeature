package com.codingwithmitch.daggermultifeature.app.di

import com.codingwithmitch.daggermultifeature.app.repository.MainRepository
import com.codingwithmitch.daggermultifeature.app.repository.MainRepositoryImpl
import com.codingwithmitch.daggermultifeature.app.data.MainLocalDataSource
import com.codingwithmitch.daggermultifeature.app.data.MainLocalDataSourceImpl
import com.codingwithmitch.daggermultifeature.feature1.data.Feature1LocalDataSource
import com.codingwithmitch.daggermultifeature.feature1.data.Feature1LocalDataSourceImpl
import com.codingwithmitch.daggermultifeature.feature1.repository.Feature1Repository
import com.codingwithmitch.daggermultifeature.feature1.repository.Feature1RepositoryImpl
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

        @Singleton
        @Provides
        @JvmStatic
        fun provideFeature1LocalDataSource(): Feature1LocalDataSource {
            return Feature1LocalDataSourceImpl()
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideFeature1Repository(
            feature1LocalDataSource: Feature1LocalDataSource
        ): Feature1Repository {
            return Feature1RepositoryImpl(feature1LocalDataSource)
        }

    }

}

