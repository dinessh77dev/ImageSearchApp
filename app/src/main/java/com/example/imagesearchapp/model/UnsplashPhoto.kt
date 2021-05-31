package com.example.imagesearchapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashPhoto(
   val id: Int,
   val description: String?,
   val urls: UnsplashPhotoUrls,
   val user: UnSplashUser,
):Parcelable