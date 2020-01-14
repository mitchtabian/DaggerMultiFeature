package com.codingwithmitch.daggermultifeature.app.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainLocalDataSourceImpl
@Inject
constructor(): MainLocalDataSource{

    override suspend fun getMainString(): String {
        return "MainFragment"
    }
}