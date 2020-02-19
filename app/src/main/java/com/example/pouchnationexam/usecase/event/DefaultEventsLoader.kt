package com.example.pouchnationexam.usecase.event

import com.example.pouchnationexam.usecase.api.Events
import com.example.pouchnationexam.usecase.api.EventsApi
import com.example.pouchnationexam.usecase.api.TokenApi
import io.reactivex.Single
import javax.inject.Inject

class DefaultEventsLoader
@Inject
constructor(
    private val tokenApi: TokenApi,
    private val eventsApi: EventsApi
) : EventsLoader {
    override fun get(): Single<Events> {
        return tokenApi.get(CLIENT_CREDENTIALS)
            .flatMap { token-> eventsApi.get(token.accessToken)}
    }


    companion object {
        const val CLIENT_CREDENTIALS = "client_credentials"
    }
}