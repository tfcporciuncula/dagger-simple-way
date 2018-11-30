package com.fredporciuncula.daggersimpleway.model

/**
 * A very simple factory to help with the unit tests.
 */
fun newPost(
    userId: Long = 0,
    id: Long = 1,
    title: String = "title",
    body: String = "body"
) = Post(userId, id, title, body)
