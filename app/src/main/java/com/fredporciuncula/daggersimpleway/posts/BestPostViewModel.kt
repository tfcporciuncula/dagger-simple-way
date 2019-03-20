package com.fredporciuncula.daggersimpleway.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fredporciuncula.daggersimpleway.model.Post
import com.fredporciuncula.daggersimpleway.service.PostsService
import io.reactivex.disposables.Disposables
import timber.log.Timber
import javax.inject.Inject

class BestPostViewModel @Inject constructor(
    private val postsService: PostsService,
    private val bestPostFinder: BestPostFinder,
    myIntFromView: Int
) : ViewModel() {

    private var disposable = Disposables.empty()

    private val bestPost = MutableLiveData<Post>()

    init {
        Timber.i("myIntFromView = $myIntFromView")
    }

    fun bestPost(): LiveData<Post> = bestPost

    fun loadPosts() {
        disposable = postsService.posts()
            .map(bestPostFinder::findBestPost)
            .subscribe(bestPost::postValue, Timber::e)
    }

    override fun onCleared() = disposable.dispose()
}
