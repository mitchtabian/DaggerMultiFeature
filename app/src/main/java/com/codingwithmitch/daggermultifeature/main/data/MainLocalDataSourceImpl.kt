package com.codingwithmitch.daggermultifeature.main.data

import javax.inject.Inject

class MainLocalDataSourceImpl
@Inject
constructor():
    MainLocalDataSource {

    override suspend fun getMainString(): String {
        return "MainFragment"
    }
}