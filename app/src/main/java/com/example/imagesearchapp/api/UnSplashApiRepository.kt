package com.example.imagesearchapp.api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.imagesearchapp.data.UnsplashPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnSplashApiRepository @Inject constructor(private val unSplashApi: UnSplashApi) {

    fun getSearchResults(query: String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { UnsplashPagingSource(unSplashApi, query) }
    ).liveData
}