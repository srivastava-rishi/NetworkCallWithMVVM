package com.rsstudio.networkcalling.api

import javax.inject.Inject

class Repository

  @Inject
  constructor(private val api: RetrofitService) {

    suspend fun getBeerInfo(page:Int,per_Page:Int) = api.getBeerDetails(page,per_Page)
}