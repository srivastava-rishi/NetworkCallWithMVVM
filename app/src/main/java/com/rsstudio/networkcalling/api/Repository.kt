package com.rsstudio.networkcalling.api

import javax.inject.Inject

class Repository

  @Inject
  constructor(private val api: RetrofitService) {

    suspend fun getBeerInfo() = api.getBeerDetails(1,10)
}