package com.codingwithmitch.daggermultifeature.feature1.data

interface Feature1LocalDataSource {

    suspend fun getFeature1MainString(): String

    suspend fun getFeature1NextString(): String
}