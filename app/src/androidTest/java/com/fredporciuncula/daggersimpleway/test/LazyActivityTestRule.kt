package com.fredporciuncula.daggersimpleway.test

import android.app.Activity
import androidx.test.rule.ActivityTestRule

class LazyActivityTestRule<T : Activity>(activityClass: Class<T>) : ActivityTestRule<T>(activityClass, false, false) {

    fun launchActivity(): T = launchActivity(null)
}
