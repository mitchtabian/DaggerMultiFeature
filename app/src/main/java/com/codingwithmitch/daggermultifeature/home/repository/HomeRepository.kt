package com.codingwithmitch.daggermultifeature.home.repository

interface HomeRepository {

    suspend fun getHomeString(): String
}