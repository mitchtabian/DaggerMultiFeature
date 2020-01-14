package com.codingwithmitch.daggermultifeature.feature1.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature2LocalDataSourceImpl
@Inject
constructor(): Feature2LocalDataSource{

    override suspend fun getFeature2MainString(): String {
        return "Feature2MainFragment"
    }

    override suspend fun getFeature2NextString(): String {
        return "Feature2NextFragment"
    }


}