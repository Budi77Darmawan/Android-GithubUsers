package com.bd_drmwan.githubusers.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultSearchUsers(
    val total_count: Int,
    val incomplete_results: Boolean,
    @SerializedName("items")
    val users: List<SearchUser>
): Parcelable

@Parcelize
data class SearchUser(
    val id: Int,
    @SerializedName("login")
    val username: String,
    @SerializedName("avatar_url")
    val imgProfile: String,
    val type: String
): Parcelable