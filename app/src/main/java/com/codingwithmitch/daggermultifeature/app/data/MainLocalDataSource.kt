package com.codingwithmitch.daggermultifeature.app.data

interface MainLocalDataSource {

    suspend fun getMainString(): String
}