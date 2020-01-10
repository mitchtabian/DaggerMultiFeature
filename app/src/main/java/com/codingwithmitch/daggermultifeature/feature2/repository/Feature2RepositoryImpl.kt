package com.codingwithmitch.daggermultifeature.feature2.repository

import com.codingwithmitch.daggermultifeature.feature1.data.Feature2LocalDataSource
import com.codingwithmitch.daggermultifeature.feature2.di.Feature2Scope
import javax.inject.Inject

@Feature2Scope
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