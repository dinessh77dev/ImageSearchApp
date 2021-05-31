package com.example.imagesearchapp.api

import com.example.imagesearchapp.BuildConfig
import com.example.imagesearchapp.model.UnsplashResponse
import com.example.imagesearchapp.others.Constants.CLIENT_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {

    //    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @Headers("Accept-Version: v1")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("client_id") clientId: String = BuildConfig.UNSPLASH_ACCESS_KEY,
        @Query("query") queryString: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<UnsplashResponse>
}