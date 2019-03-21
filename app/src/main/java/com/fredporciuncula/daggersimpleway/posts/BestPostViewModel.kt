package com.fredporciuncula.daggersimpleway.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fredporciuncula.daggersimpleway.model.Post
import com.fredporciuncula.daggersimpleway.service.PostsService
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.disposables.Disposables
import timber.log.Timber

class BestPostViewModel @AssistedInject constructor(
    private val postsService: PostsService,
    private val bestPostFinder: BestPostFinder,
    @Assisted myIntFromView: Int
) : ViewModel() {

    @AssistedInject.Factory
    interface Factory {
        fun create(myIntFromView: Int): BestPostViewModel
    }

    init {
        Timber.i("myIntFromView = $myIntFromView")
    }

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
