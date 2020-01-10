package com.codingwithmitch.daggermultifeature.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.daggermultifeature.home.di.HomeScope
import com.codingwithmitch.daggermultifeature.home.repository.HomeRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HomeScope
class HomeViewModel
@Inject
constructor(
    private val homeRepository: HomeRepository
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


