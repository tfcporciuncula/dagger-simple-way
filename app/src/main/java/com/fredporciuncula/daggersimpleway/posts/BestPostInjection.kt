package com.fredporciuncula.daggersimpleway.posts

import com.fredporciuncula.daggersimpleway.di.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [BestPostModule::class])
interface BestPostComponent {

    fun bestPostViewModelFactory(): ViewModelFactory<BestPostViewModel>
}

@Module
class BestPostModule(@get:Provides val myIntFromView: Int)
