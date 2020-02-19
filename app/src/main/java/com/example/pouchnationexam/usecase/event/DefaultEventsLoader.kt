package com.example.pouchnationexam.usecase.event

import com.example.pouchnationexam.usecase.api.Token
import com.example.pouchnationexam.usecase.api.TokenApi
import io.reactivex.Single
import javax.inject.Inject

class DefaultEventsLoader
    @Inject
    constructor(
        private val api : TokenApi
    )
    : EventsLoader {
    override fun get() : Single<Token> = api.get(CLIENT_CREDENTIALS)


    companion object {
        const val CLIENT_CREDENTIALS = "client_credentials"
    }
}