package com.fredporciuncula.daggersimpleway.model

fun newPost(
    userId: Long = 0,
    id: Long = 1,
    title: String = "title",
    body: String = "body"
) = Post(userId, id, title, body)
