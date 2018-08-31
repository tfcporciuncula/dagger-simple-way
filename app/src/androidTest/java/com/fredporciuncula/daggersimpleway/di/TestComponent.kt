package com.fredporciuncula.daggersimpleway.di

import dagger.Component
import javax.inject.Singleton

/**
 * A test component that overrides our [ApplicationComponent] and includes a test module.
 */
@Singleton
@Component(modules = [RetrofitTestModule::class])
interface TestComponent : ApplicationComponent {

    @Component.Builder
    interface Builder : ApplicationComponent.Builder
}
