package com.fredporciuncula.daggersimpleway.posts

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.fredporciuncula.daggersimpleway.model.newPost
import com.fredporciuncula.daggersimpleway.service.PostsService
import com.google.common.truth.Truth.assertThat
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BestPostViewModelTest {

    @get:Rule val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock private lateinit var postsService: PostsService

    @Mock private lateinit var bestPostFinder: BestPostFinder

    private val viewModel get() = BestPostViewModel(postsService, bestPostFinder)

    @Test fun testBestPost() {
        val posts = listOf(newPost(id = 10), newPost(id = 20))
        given(postsService.posts()).willReturn(Single.just(posts))
        given(bestPostFinder.findBestPost(posts)).willReturn(posts.first())

        with(viewModel) {
            loadPosts()
            bestPost().observeForever {
                assertThat(it).isEqualTo(posts.first())
            }
        }
    }
}
