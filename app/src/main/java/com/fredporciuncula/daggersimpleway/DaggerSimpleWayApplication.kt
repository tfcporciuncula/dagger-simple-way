package com.fredporciuncula.daggersimpleway

import android.app.Application
import com.fredporciuncula.daggersimpleway.di.ApplicationComponent
import com.fredporciuncula.daggersimpleway.di.DaggerApplicationComponent
import com.fredporciuncula.daggersimpleway.di.DaggerComponentProvider
import timber.log.Timber

class DaggerSimpleWayApplication : Application(), DaggerComponentProvider {

    override val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationContext(applicationContext)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
