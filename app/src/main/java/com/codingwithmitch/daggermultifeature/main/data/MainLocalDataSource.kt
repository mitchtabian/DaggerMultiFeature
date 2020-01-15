package com.codingwithmitch.daggermultifeature.main.data

interface MainLocalDataSource {

    suspend fun getMainString(): String
}