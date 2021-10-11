package com.bd_drmwan.githubusers.modules

import com.bd_drmwan.githubusers.services.AppService
import com.bd_drmwan.githubusers.BuildConfig.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideBaseService(
        client: OkHttpClient
    ): AppService {
        return NetworkModule.buildRetrofit(
            BASE_URL,
            client
        ).create(AppService::class.java)
    }
}