package com.example.pouchnationexam.framework

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Module that provides Android Framework related dependencies.
 */
@Module
class AndroidModule {

    @Provides
    internal fun provideContext(application: PouchNationApplication): Context {
        return application.applicationContext
    }
}