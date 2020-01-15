package com.codingwithmitch.daggermultifeature.main.repository

interface MainRepository {

    suspend fun getHomeString(): String
}