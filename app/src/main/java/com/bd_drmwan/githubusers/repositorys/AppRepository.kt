package com.bd_drmwan.githubusers.repositorys

import com.bd_drmwan.githubusers.services.AppService
import com.bd_drmwan.githubusers.models.ResultSearchUsers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppRepository @Inject constructor(private val appService: AppService) {

    fun getUsersByUsername(query: String): Flow<ResultSearchUsers> {
        return flow {
            val result = appService.getUsersByUsername(query)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

}