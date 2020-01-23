package com.codingwithmitch.daggermultifeature.feature1.data

import com.codingwithmitch.daggermultifeature.feature1.di.Feature1FragmentScope
import javax.inject.Inject

@Feature1FragmentScope
class Feature1LocalDataSourceImpl
@Inject
constructor(): Feature1LocalDataSource{

    override suspend fun getFeature1MainString(): String {
        return "Feature1MainFragment"
    }

    override suspend fun getFeature1NextString(): String {
        return "Feature1NextFragment"
    }

    override suspend fun getFeature1FinalString(): String {
        return "Feature1FinalFragment"
    }
}