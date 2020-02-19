package com.example.pouchnationexam.usecase.api

import com.example.pouchnationexam.BuildConfig
import io.reactivex.Single
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface TokenApi {

    @Headers(
        "Content-Type: application/x-www-form-urlencoded",
        "Authorization: Basic ${BuildConfig.BASE_64}"
    )
    @POST("token")
    fun get(@Query("grant_type") grantType: String) : Single<Token>

    // /token?grant_type=client_credentials/

}