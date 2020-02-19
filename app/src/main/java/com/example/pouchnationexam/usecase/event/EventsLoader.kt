package com.example.pouchnationexam.usecase.event

import com.example.pouchnationexam.usecase.api.Token
import io.reactivex.Single

interface EventsLoader {
    fun get() : Single<Token>
}