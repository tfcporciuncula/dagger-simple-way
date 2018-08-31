package com.fredporciuncula.daggersimpleway.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post(
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String
)
