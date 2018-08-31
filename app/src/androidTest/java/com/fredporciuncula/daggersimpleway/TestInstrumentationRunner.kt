package com.fredporciuncula.daggersimpleway

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner

/**
 * This exists just so our instrumentation tests use our [TestApplication] as the application class.
 *
 * It needs to be referenced in the `build.gradle` file under `testInstrumentationRunner`.
 */
class TestInstrumentationRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, TestApplication::class.java.name, context)
    }
}
