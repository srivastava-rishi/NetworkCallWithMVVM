package com.rsstudio.networkcalling.api

data class BeerInfoNetworkEntity(
    val id: Int,
    val abv: Double,
    val description: String,
    val image_url: String,
    val name: String,
    val tagline: String,
)
