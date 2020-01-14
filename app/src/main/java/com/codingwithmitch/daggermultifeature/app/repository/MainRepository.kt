package com.codingwithmitch.daggermultifeature.app.repository

interface MainRepository {

    suspend fun getHomeString(): String
}