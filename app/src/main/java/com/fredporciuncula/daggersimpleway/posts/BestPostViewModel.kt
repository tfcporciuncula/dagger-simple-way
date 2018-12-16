package com.fredporciuncula.daggersimpleway.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fredporciuncula.daggersimpleway.model.Post
import com.fredporciuncula.daggersimpleway.service.PostsService
import io.reactivex.disposables.Disposables
import timber.log.Timber
import javax.inject.Inject

/**
 * A simple [ViewModel] that makes use of its (constructor injected) dependencies and exposes a [LiveData].
 */
class BestPostViewModel @Inject constructor(
    private val postsService: PostsService,
    private val bestPostFinder: BestPostFinder
) : ViewModel() {

    private var disposable = Disposables.empty()

    private val bestPost = MutableLiveData<Post>()

    fun bestPost(): LiveData<Post> = bestPost

    fun loadPosts() {
        disposable = postsService.posts()
            .map(bestPostFinder::findBestPost)
            .subscribe(bestPost::postValue, Timber::e)
    }

    override fun onCleared() = disposable.dispose()
}
