package com.example.pouchnationexam.framework

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

open class PouchNationApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    private lateinit var component: PouchNationComponent

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        instance = this
        super.onCreate()
        initializeComponent().inject(this)
    }

    protected open fun initializeComponent(): PouchNationComponent {
        component = DaggerPouchNationComponent
            .builder()
            .application(this)
            .build()
        return component
    }

    companion object {
        lateinit var instance: PouchNationApplication
            private set
    }

}