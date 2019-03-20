package com.fredporciuncula.daggersimpleway.posts

import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [BestPostModule::class])
interface BestPostComponent {

    val bestPostViewModel: BestPostViewModel
}

@Module
class BestPostModule(@get:Provides val myIntFromView: Int)
