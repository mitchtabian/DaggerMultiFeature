package com.codingwithmitch.daggermultifeature.feature1.repository

import com.codingwithmitch.daggermultifeature.feature1.data.Feature1LocalDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature1RepositoryImpl
@Inject
constructor(
    private val feature1LocalDataSource: Feature1LocalDataSource
): Feature1Repository{

    override suspend fun getFeature1MainString(): String {
        return feature1LocalDataSource.getFeature1MainString()
    }

    override suspend fun getFeature1NextString(): String {
        return feature1LocalDataSource.getFeature1NextString()
    }

}