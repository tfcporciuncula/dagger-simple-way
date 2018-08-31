package com.fredporciuncula.daggersimpleway

import android.app.Application
import com.fredporciuncula.daggersimpleway.di.DaggerComponentProvider
import com.fredporciuncula.daggersimpleway.di.DaggerTestComponent

class TestApplication : Application(), DaggerComponentProvider {

    override val component
        get() = DaggerTestComponent.builder()
            .applicationContext(applicationContext)
            .build()
}
