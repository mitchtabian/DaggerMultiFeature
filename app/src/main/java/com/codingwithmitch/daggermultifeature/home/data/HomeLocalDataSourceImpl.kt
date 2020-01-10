package com.codingwithmitch.daggermultifeature.home.data

import com.codingwithmitch.daggermultifeature.home.di.HomeScope
import javax.inject.Inject

@HomeScope
class HomeLocalDataSourceImpl
@Inject
constructor(): HomeLocalDataSource{

    override suspend fun getHomeString(): String {
        return "HomeFragment"
    }
}