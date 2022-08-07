package com.rsstudio.networkcalling.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rsstudio.networkcalling.api.BeerInfoNetworkEntity
import com.rsstudio.networkcalling.api.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val repository: Repository
) : ViewModel() {

    var logTag = "@MainViewModel"

    private val _beerData = MutableLiveData<List<BeerInfoNetworkEntity>>()

    init {
        getBeerInfo()
    }


    private fun getBeerInfo() = viewModelScope.launch {

        repository.getBeerInfo().let { response ->

            if (response.isSuccessful){
                _beerData.postValue(response.body())
            }else{
                Log.d(logTag, "error: ${response.errorBody()} ")
            }

        }
    }

}