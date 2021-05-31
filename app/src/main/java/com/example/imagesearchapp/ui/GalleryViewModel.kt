package com.example.imagesearchapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.imagesearchapp.api.ApiRepository

class GalleryViewModel @ViewModelInject constructor(private val repository: ApiRepository) :
    ViewModel() {
}