package com.rsstudio.networkcalling.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {


    @GET("beers")
    suspend fun getBeerDetails(
      @Query("page") page:Int,
      @Query("per_page") per_page:Int
    ): Response<List<BeerInfoNetworkEntity>>

}