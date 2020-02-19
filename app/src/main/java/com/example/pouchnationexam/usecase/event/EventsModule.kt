package com.example.pouchnationexam.usecase.event

import dagger.Binds
import dagger.Module

@Module
interface EventsModule {

    @Binds
    fun provideEventsLoader(loader: DefaultEventsLoader): EventsLoader
}