package com.example.lopputyo.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://space.fmi.fi/MIRACLE/RWC/data/"

interface AuroraApi {
    @GET("r_index_latest_en.json")
    suspend fun getLatest(): LatestValues

    companion object {
        var ApiService: AuroraApi? = null

        fun getInstance(): AuroraApi {
            if (ApiService === null) {
                ApiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(AuroraApi::class.java)
            }
            return ApiService!!
        }
    }
}