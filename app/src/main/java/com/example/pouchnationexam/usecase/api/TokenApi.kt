package com.example.pouchnationexam.usecase.api

import io.reactivex.Single
import retrofit2.http.Headers
import retrofit2.http.POST

interface TokenApi {

    @Headers(
        "Content-Type: application/x-www-form-urlencoded",
        "Authorization: Basic MTY5MDc4cDJjcTdmc2E5bTRjZmlwZ3E1NmQ6MWllbzZpaTVjMjlmbWdsajYwaGFncHJmaTJydXI4bjJoNHZyODl0azBib2VrdTEyOGNxNQ=="
    )
    @POST
    fun get() : Single<Token>

}