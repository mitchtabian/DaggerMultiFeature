package com.codingwithmitch.daggermultifeature.feature1.data

import com.codingwithmitch.daggermultifeature.feature2.di.Feature2Scope
import javax.inject.Inject

@Feature2Scope
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