package com.fredporciuncula.daggersimpleway.posts

import com.fredporciuncula.daggersimpleway.model.newPost
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BestPostFinderTest {

    private val bestPostFinder get() = BestPostFinder()

    @Test fun testBestPostFinder() {
        val posts = listOf(newPost(id = 1), newPost(id = 2), newPost(id = 2))

        val bestPost = bestPostFinder.findBestPost(posts)

        assertThat(bestPost).isEqualTo(posts.first())
    }
}
