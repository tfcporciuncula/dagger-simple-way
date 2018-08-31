package com.fredporciuncula.daggersimpleway.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitTestModule::class])
interface TestComponent : ApplicationComponent {

    @Component.Builder
    interface Builder : ApplicationComponent.Builder
}
