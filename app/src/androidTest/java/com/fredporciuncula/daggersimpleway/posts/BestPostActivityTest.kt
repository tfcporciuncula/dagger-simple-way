package com.fredporciuncula.daggersimpleway.posts

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
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

@RunWith(AndroidJUnit4::class)
class BestPostActivityTest {

    @get:Rule var activityRule = LazyActivityTestRule(BestPostActivity::class.java)

    @Before fun setup() {
        RESTMockServerStarter.startSync(
            AndroidAssetsFileParser(InstrumentationRegistry.getInstrumentation().context),
            AndroidLogger()
        )
    }

    @After fun tearDown() = RESTMockServer.shutdown()

    @Test fun testBestPostActivityHappyPath() {
        RESTMockServer.whenGET(pathContains("posts")).thenReturnFile(200, "posts.json")
        activityRule.launchActivity()

        onView(withId(R.id.bestPost)).check(matches(withText("body1")))
    }
}
