package com.fredporciuncula.daggersimpleway.posts

import com.fredporciuncula.daggersimpleway.model.Post
import dagger.Reusable
import javax.inject.Inject

/**
 * Silly class just so the [BestPostViewModel] has another dependency.
 *
 * Let's pretend there's some logic going on here.
 */
@Reusable
class BestPostFinder @Inject constructor() {

    fun findBestPost(posts: List<Post>) = posts.first()
}
