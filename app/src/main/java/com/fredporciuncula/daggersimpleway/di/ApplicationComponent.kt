package com.fredporciuncula.daggersimpleway.di

import android.content.Context
import com.fredporciuncula.daggersimpleway.posts.BestPostViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun applicationContext(applicationContext: Context): Builder
        fun build(): ApplicationComponent
    }

    fun bestPostViewModelFactory(): ViewModelFactory<BestPostViewModel>
}
