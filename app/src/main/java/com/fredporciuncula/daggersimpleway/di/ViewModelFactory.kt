package com.fredporciuncula.daggersimpleway.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Lazy
import dagger.Reusable
import javax.inject.Inject

class ViewModelFactory<VM : ViewModel> @Inject constructor(
    private val viewModel: Lazy<VM>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = viewModel.get() as T
}
