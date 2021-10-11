package com.bd_drmwan.githubusers.viewmodels

import androidx.lifecycle.ViewModel
import com.bd_drmwan.githubusers.models.GeneralError
import com.google.gson.GsonBuilder
import retrofit2.HttpException

open class BaseViewModel: ViewModel() {

    fun handleErrorResponse(e: Throwable): String {
        return when (e) {
            is HttpException -> {
                val gson = GsonBuilder().create()
                val generalError = gson.fromJson(e.response()?.errorBody()?.string(), GeneralError::class.java)
                generalError.message
            }
            else -> {
                e.localizedMessage ?: "Internal server error"
            }
        }
    }
}