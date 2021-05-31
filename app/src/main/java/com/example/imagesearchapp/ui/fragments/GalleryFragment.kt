package com.example.imagesearchapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.imagesearchapp.R
import com.example.imagesearchapp.adapter.UnSplashPhotoAdapter
import com.example.imagesearchapp.databinding.FragmentGalleryBinding
import com.example.imagesearchapp.ui.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_gallery.*

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val viewModel by viewModels<GalleryViewModel>()
    private lateinit var adapter: UnSplashPhotoAdapter

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = UnSplashPhotoAdapter()
        _binding = FragmentGalleryBinding.bind(view)

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }

        viewModel.photos.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitData(viewLifecycleOwner.lifecycle, it)
            }
        })
        viewModel.searchPhotos("cats")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}