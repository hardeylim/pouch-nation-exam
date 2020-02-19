package com.example.pouchnationexam.usecase.api

import com.example.pouchnationexam.BuildConfig
import io.reactivex.Single
import retrofit2.http.Headers
import retrofit2.http.POST

interface TokenApi {

    @Headers(
        "Content-Type: application/x-www-form-urlencoded",
        "Authorization: Basic ${BuildConfig.BASE_64}"
    )
    @POST
    fun get() : Single<Token>

}