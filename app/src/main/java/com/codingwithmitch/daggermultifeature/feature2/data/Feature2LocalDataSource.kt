package com.codingwithmitch.daggermultifeature.feature1.data

interface Feature2LocalDataSource {

    suspend fun getFeature2MainString(): String

    suspend fun getFeature2NextString(): String
}