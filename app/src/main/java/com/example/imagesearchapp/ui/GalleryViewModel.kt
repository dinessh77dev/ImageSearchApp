package com.example.imagesearchapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.imagesearchapp.api.UnSplashApiRepository
import com.example.imagesearchapp.model.UnsplashPhoto
import kotlinx.coroutines.launch

class GalleryViewModel @ViewModelInject
constructor(
    private val repository: UnSplashApiRepository
) : ViewModel() {

    private val currentQuery = MutableLiveData("dogs")

    val photos =currentQuery.switchMap { queryString ->
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }
}