package com.example.pouchnationexam.usecase.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface EventsApi {

    @GET("items")
    @Headers("Content-Type: application/json")
    fun get(@Header("Auth") auth: String): Single<Events>
}