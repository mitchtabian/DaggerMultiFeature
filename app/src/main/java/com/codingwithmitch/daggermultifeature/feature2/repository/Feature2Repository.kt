package com.codingwithmitch.daggermultifeature.feature2.repository

interface Feature2Repository {

    suspend fun getFeature2MainString(): String

    suspend fun getFeature2NextString(): String
}