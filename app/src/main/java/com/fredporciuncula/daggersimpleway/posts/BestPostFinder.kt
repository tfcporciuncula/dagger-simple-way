package com.fredporciuncula.daggersimpleway.posts

import com.fredporciuncula.daggersimpleway.model.Post
import dagger.Reusable
import javax.inject.Inject

@Reusable
class BestPostFinder @Inject constructor() {

    fun findBestPost(posts: List<Post>) = posts[0]
}
