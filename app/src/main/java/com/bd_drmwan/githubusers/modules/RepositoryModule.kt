package com.bd_drmwan.githubusers.modules

import com.bd_drmwan.githubusers.services.AppService
import com.bd_drmwan.githubusers.repositorys.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideAppRepository(
        appService: AppService
    ): AppRepository {
        return AppRepository(appService)
    }
}