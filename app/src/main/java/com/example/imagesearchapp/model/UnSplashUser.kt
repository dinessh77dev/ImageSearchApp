package com.example.imagesearchapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnSplashUser(
    val name: String,
    val username: String
):Parcelable {
    val attributionUrl get() = "https://unsplash.com/$username?utm_source=ImageSearch&utm_medium=referral"
}
