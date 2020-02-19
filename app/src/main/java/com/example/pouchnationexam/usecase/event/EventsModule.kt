package com.example.pouchnationexam.usecase.event

import dagger.Binds
import dagger.Module

@Module
abstract class EventsModule {

    @Binds
    internal    abstract fun provideEventsLoader(loader: DefaultEventsLoader): EventsLoader
}