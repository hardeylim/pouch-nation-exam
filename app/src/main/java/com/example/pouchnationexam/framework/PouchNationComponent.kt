package com.example.pouchnationexam.framework

import com.example.pouchnationexam.framework.rx.RxUtilityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        RxUtilityModule::class
    ]
)
@Singleton
interface PouchNationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: PouchNationApplication): Builder
        fun build(): PouchNationComponent
    }

    fun inject(app: PouchNationApplication)
}