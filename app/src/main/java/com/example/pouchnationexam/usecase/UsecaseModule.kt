package com.example.pouchnationexam.usecase

import com.example.pouchnationexam.usecase.api.ApiModule
import com.example.pouchnationexam.usecase.event.EventsModule
import dagger.Module

@Module(
    includes = [
        ApiModule::class,
        EventsModule::class

    ]
)
abstract class UsecaseModule {
}