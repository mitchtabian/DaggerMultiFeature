package com.codingwithmitch.daggermultifeature.feature1.repository

interface Feature1Repository {

    suspend fun getFeature1MainString(): String

    suspend fun getFeature1NextString(): String

    suspend fun getFeature1FinalString(): String
}