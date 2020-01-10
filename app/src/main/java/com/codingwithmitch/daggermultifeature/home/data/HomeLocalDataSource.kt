package com.codingwithmitch.daggermultifeature.home.data

interface HomeLocalDataSource {

    suspend fun getHomeString(): String
}