package com.bd_drmwan.githubusers.services

import com.bd_drmwan.githubusers.models.ResultSearchUsers
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppService {
    @GET("search/users")
    suspend fun getUsersByUsername(
        @Query("q") username: String
    ): ResultSearchUsers

    @GET("users/{username}")
    suspend fun getDetailUser(
        @Path("username") username: String
    )
}