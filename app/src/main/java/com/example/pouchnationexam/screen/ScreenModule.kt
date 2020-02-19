package com.example.pouchnationexam.screen

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ScreenModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity() : MainActivity
}