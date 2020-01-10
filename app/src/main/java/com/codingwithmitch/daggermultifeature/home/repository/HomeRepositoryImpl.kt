package com.codingwithmitch.daggermultifeature.home.repository

import com.codingwithmitch.daggermultifeature.home.data.HomeLocalDataSource
import com.codingwithmitch.daggermultifeature.home.di.HomeScope
import javax.inject.Inject


@HomeScope
class HomeRepositoryImpl
@Inject
constructor(
    private val localDataSource: HomeLocalDataSource
) : HomeRepository{

    override suspend fun getHomeString(): String {
        return localDataSource.getHomeString()
    }
}
