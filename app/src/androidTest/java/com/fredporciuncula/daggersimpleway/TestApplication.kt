package com.fredporciuncula.daggersimpleway

import android.app.Application
import com.fredporciuncula.daggersimpleway.di.DaggerComponentProvider
import com.fredporciuncula.daggersimpleway.di.DaggerTestComponent

/**
 * A simple application class that exposes the test component for the instrumentation tests.
 */
class TestApplication : Application(), DaggerComponentProvider {

    override val component
        get() = DaggerTestComponent.builder()
            .applicationContext(applicationContext)
            .build()
}
