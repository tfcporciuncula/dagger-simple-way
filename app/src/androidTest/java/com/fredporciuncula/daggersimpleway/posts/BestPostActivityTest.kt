package com.fredporciuncula.daggersimpleway.posts

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import com.fredporciuncula.daggersimpleway.R
import com.fredporciuncula.daggersimpleway.test.LazyActivityTestRule
import io.appflate.restmock.RESTMockServer
import io.appflate.restmock.RESTMockServerStarter
import io.appflate.restmock.android.AndroidAssetsFileParser
import io.appflate.restmock.android.AndroidLogger
import io.appflate.restmock.utils.RequestMatchers.pathContains
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Thanks to Dagger and our test setup, we won't actually be accessing
 * any external resource and we'll only be hitting the [RESTMockServer].
 */
@RunWith(AndroidJUnit4::class)
class BestPostActivityTest {

    @get:Rule var activityRule = LazyActivityTestRule(BestPostActivity::class.java)

    @Before fun setup() {
        RESTMockServerStarter.startSync(AndroidAssetsFileParser(InstrumentationRegistry.getContext()), AndroidLogger())
    }

    @After fun tearDown() = RESTMockServer.shutdown()

    @Test fun testBestPostActivityHappyPath() {
        RESTMockServer.whenGET(pathContains("posts")).thenReturnFile(200, "posts.json")
        activityRule.launchActivity()

        onView(withId(R.id.bestPost)).check(matches(withText("body1")))
    }
}
