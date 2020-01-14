package com.codingwithmitch.daggermultifeature.app.repository

import com.codingwithmitch.daggermultifeature.app.data.MainLocalDataSource
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MainRepositoryImpl
@Inject
constructor(
    private val localDataSource: MainLocalDataSource
) : MainRepository{

    override suspend fun getHomeString(): String {
        return localDataSource.getMainString()
    }
}
