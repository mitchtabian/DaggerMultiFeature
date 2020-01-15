package com.codingwithmitch.daggermultifeature.feature1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.daggermultifeature.feature1.di.Feature1FragmentScope
import com.codingwithmitch.daggermultifeature.feature1.repository.Feature1Repository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@Feature1FragmentScope
class Feature1ViewModel
@Inject
constructor(
    private val feature1Repository: Feature1Repository
) : ViewModel(){


    private val _feature1MainString: MutableLiveData<String> = MutableLiveData()
    private val _feature1NextString: MutableLiveData<String> = MutableLiveData()

    val feature1MainString: LiveData<String> get() = _feature1MainString
    val feature1NextString: LiveData<String> get() = _feature1NextString

    fun retrieveMainString(){
        viewModelScope.launch {
            val mainString = feature1Repository.getFeature1MainString()
            _feature1MainString.value = mainString
        }
    }

    fun retrieveNextString(){
        viewModelScope.launch {
            val nextString = feature1Repository.getFeature1NextString()
            _feature1NextString.value = nextString
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}


