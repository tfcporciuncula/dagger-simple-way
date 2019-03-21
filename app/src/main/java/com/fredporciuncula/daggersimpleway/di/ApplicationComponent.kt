package com.fredporciuncula.daggersimpleway.di

import android.content.Context
import com.fredporciuncula.daggersimpleway.posts.BestPostViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, AssistedInjectModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun applicationContext(applicationContext: Context): Builder
        fun build(): ApplicationComponent
    }

    val bestPostViewModelFactory: BestPostViewModel.Factory
}

@AssistedModule
@Module(includes = [AssistedInject_AssistedInjectModule::class])
interface AssistedInjectModule
