package com.example.pouchnationexam.usecase.event

import com.example.pouchnationexam.usecase.api.Events
import com.example.pouchnationexam.usecase.api.Token
import io.reactivex.Single
import io.reactivex.annotations.SchedulerSupport

interface EventsLoader {
    @SchedulerSupport(value = "io.reactivex:io")
    fun get() : Single<Events>
}