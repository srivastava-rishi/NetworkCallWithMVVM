package com.rsstudio.networkcalling.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
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

    // the pattern we should follow generally
    private val _beerData: MutableLiveData<List<BeerInfoNetworkEntity>> = MutableLiveData()
    val beerData: LiveData<List<BeerInfoNetworkEntity>> get() = _beerData

    init {
        getBeerInfo()
    }


    private fun getBeerInfo() {

        viewModelScope.launch {

            val result = repository.getBeerInfo(1,10)

            _beerData.value = result

    }
}

}