package com.example.imagesearchapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.ItemUnsplashPhotoBinding
import com.example.imagesearchapp.model.UnsplashPhoto

class UnSplashPhotoAdapter :
    PagingDataAdapter<UnsplashPhoto, UnSplashPhotoAdapter.PhotoViewHolder>(diffCallBack) {

//    class PhotoViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
//
//    }

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<UnsplashPhoto>() {
            override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: UnsplashPhoto,
                newItem: UnsplashPhoto
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class PhotoViewHolder(private val binding: ItemUnsplashPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: UnsplashPhoto) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(imageView)

                itemTextView.text = photo.user.username
            }
        }
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        currentItem?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            ItemUnsplashPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }
}