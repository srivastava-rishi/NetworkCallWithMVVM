package com.rsstudio.networkcalling.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rsstudio.networkcalling.api.BeerInfoNetworkEntity
import com.rsstudio.networkcalling.api.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val repository: Repository
) : ViewModel() {

    private val _response = MutableLiveData<List<BeerInfoNetworkEntity>>()

}