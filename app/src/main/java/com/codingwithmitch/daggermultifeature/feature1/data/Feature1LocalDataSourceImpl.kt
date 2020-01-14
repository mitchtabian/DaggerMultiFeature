package com.codingwithmitch.daggermultifeature.feature1.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature1LocalDataSourceImpl
@Inject
constructor(): Feature1LocalDataSource{

    override suspend fun getFeature1MainString(): String {
        return "Feature1MainFragment"
    }

    override suspend fun getFeature1NextString(): String {
        return "Feature1NextFragment"
    }


}