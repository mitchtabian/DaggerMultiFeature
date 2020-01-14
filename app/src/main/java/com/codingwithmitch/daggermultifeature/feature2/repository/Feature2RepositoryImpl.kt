package com.codingwithmitch.daggermultifeature.feature2.repository

import com.codingwithmitch.daggermultifeature.feature1.data.Feature2LocalDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature2RepositoryImpl
@Inject
constructor(
    private val feature2LocalDataSource: Feature2LocalDataSource
): Feature2Repository{

    override suspend fun getFeature2MainString(): String {
        return feature2LocalDataSource.getFeature2MainString()
    }

    override suspend fun getFeature2NextString(): String {
        return feature2LocalDataSource.getFeature2NextString()
    }


}