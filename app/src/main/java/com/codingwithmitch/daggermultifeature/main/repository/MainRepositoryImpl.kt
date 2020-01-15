package com.codingwithmitch.daggermultifeature.main.repository

import com.codingwithmitch.daggermultifeature.main.data.MainLocalDataSource
import javax.inject.Inject


class MainRepositoryImpl
@Inject
constructor(
    private val localDataSource: MainLocalDataSource
) : MainRepository {

    override suspend fun getHomeString(): String {
        return localDataSource.getMainString()
    }
}
