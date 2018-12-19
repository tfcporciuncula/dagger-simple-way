package com.fredporciuncula.daggersimpleway.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * This is the only [ViewModel] factory we'll ever need to write as long as we stick with Dagger.
 *
 * You can use it to inject whatever `ViewModel` you want, and it won't recreate the `ViewModel`
 * dependencies on configuration change since the `ViewModel` dependency itself is [Lazy] here.
 *
 * Credits: https://www.reddit.com/r/androiddev/comments/73nge5/the_only_android_viewmodel_factory_youll_need/
 */
class ViewModelFactory<VM : ViewModel> @Inject constructor(
    private val viewModel: Provider<VM>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = viewModel.get() as T
}
