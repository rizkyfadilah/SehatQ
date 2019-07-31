package com.rizkyfadilah.sehatq.di.component

import android.app.Application
import com.rizkyfadilah.sehatq.core.App
import com.rizkyfadilah.sehatq.di.builder.ActivityBuilder
import com.rizkyfadilah.sehatq.di.module.ContextModule
import com.rizkyfadilah.sehatq.di.module.DataBaseModule
import com.rizkyfadilah.sehatq.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    ActivityBuilder::class,
    ContextModule::class,
    DataBaseModule::class])
interface CoreComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }

}