package com.codingwithmitch.daggermultifeature.feature2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.daggermultifeature.feature2.repository.Feature2Repository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class Feature2ViewModel
@Inject
constructor(
    private val feature2Repository: Feature2Repository
) : ViewModel(){

    private val _feature2MainString: MutableLiveData<String> = MutableLiveData()
    private val _feature2NextString: MutableLiveData<String> = MutableLiveData()

    val feature2MainString: LiveData<String> get() = _feature2MainString
    val feature2NextString: LiveData<String> get() = _feature2NextString

    fun retrieveMainString(){
        viewModelScope.launch {
            val mainString = feature2Repository.getFeature2MainString()
            _feature2MainString.value = mainString
        }
    }

    fun retrieveNextString(){
        viewModelScope.launch {
            val nextString = feature2Repository.getFeature2NextString()
            _feature2NextString.value = nextString
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}


