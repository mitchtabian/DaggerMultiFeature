package com.codingwithmitch.daggermultifeature.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.daggermultifeature.app.repository.MainRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
class MainViewModel
@Inject
constructor(
    private val homeRepository: MainRepository
) : ViewModel(){

    private val _homeString: MutableLiveData<String> = MutableLiveData()

    val homeString: LiveData<String> get() = _homeString

    fun retrieveHomeString(){
        viewModelScope.launch {
            val homeString = homeRepository.getHomeString()
            _homeString.value = homeString
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}


