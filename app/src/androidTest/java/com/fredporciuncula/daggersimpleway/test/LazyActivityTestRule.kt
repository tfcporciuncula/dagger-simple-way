package com.fredporciuncula.daggersimpleway.test

import android.app.Activity
import androidx.test.rule.ActivityTestRule

/**
 * An [ActivityTestRule] that doesn't automatically launch the activity before each test.
 *
 * This is important if we need to make sure some setup on the test runs before the activity is launched.
 */
class LazyActivityTestRule<T : Activity>(activityClass: Class<T>) : ActivityTestRule<T>(activityClass, false, false) {

    fun launchActivity(): T = launchActivity(null)
}
