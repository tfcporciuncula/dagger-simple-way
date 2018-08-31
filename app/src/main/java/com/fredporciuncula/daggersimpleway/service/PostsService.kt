package com.fredporciuncula.daggersimpleway.service

import com.fredporciuncula.daggersimpleway.model.Post
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Nothing to see here.
 */
interface PostsService {

    @GET("posts")
    fun posts(): Single<List<Post>>
}
