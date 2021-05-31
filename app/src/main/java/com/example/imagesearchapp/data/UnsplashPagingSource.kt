package com.example.imagesearchapp.data

import androidx.paging.PagingSource
import com.example.imagesearchapp.api.UnSplashApi
import com.example.imagesearchapp.model.UnsplashPhoto
import com.example.imagesearchapp.others.Constants.UNSPLASH_STARTING_INDEX
import retrofit2.HttpException
import java.io.IOException

class UnsplashPagingSource(
    private val unSplashApi: UnSplashApi,
    private val query: String
) : PagingSource<Int, UnsplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val position = params.key ?: UNSPLASH_STARTING_INDEX

        return try {
            val response = unSplashApi.searchPhotos(
                query = query,
                page = position,
                perPage = params.loadSize
            )
            val result = response.body()

            LoadResult.Page(
                data = result?.results!!,
                prevKey = if (position == UNSPLASH_STARTING_INDEX) null else position - 1,
                nextKey = if (result.results.isEmpty()) null else position + 1
            )
        } catch (ex: IOException) {
            LoadResult.Error(ex)
        } catch (ex: HttpException) {
            LoadResult.Error(ex)
        }
    }
}