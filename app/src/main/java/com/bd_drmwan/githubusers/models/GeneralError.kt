package com.bd_drmwan.githubusers.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GeneralError(
    val message: String = "Internal server error",
    val documentation_url: String?
): Parcelable
