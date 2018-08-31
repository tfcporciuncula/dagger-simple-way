package com.fredporciuncula.daggersimpleway.di

import com.fredporciuncula.daggersimpleway.service.PostsService
import dagger.Module
import dagger.Provides
import io.appflate.restmock.RESTMockServer
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * The test module for our service. The only thing we do different is to pass
 * [RESTMockServer]'s URL as the base URL so we can use it in our tests.
 */
@Module
object RetrofitTestModule {

    @JvmStatic @Provides @Singleton
    fun provideBooksService(): PostsService = Retrofit.Builder()
        .baseUrl(RESTMockServer.getUrl())
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
        .create(PostsService::class.java)
}
