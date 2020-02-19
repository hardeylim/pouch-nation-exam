package com.example.pouchnationexam.framework.rx


import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class RxUtilityModule {

    @Provides
    @Singleton
    internal fun provideRxSchedulerUtils(): RxSchedulerUtils {
        return DefaultRxSchedulerUtils()
    }
}
