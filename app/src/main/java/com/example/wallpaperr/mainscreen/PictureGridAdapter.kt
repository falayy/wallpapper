package com.example.wallpaperr.mainscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperr.databinding.ImageGridItemBinding
import com.example.wallpaperr.domain.Images

class PictureGridAdapter :ListAdapter<Images, PictureGridAdapter.ImageViewHolder>(ImageDiffCallback()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder.from(parent)
    }



    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
       val items = getItem(position)
        holder.bind(items)
      }



    class ImageViewHolder private constructor(val binding: ImageGridItemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind (items : Images){
            binding.images = items
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ImageViewHolder {
                val layoutInflater =LayoutInflater.from(parent.context)
              val binding = ImageGridItemBinding.inflate(layoutInflater, parent, false)
                   return ImageViewHolder(binding)
            }
        }

    }


    class ImageDiffCallback : DiffUtil.ItemCallback<Images>() {
        override fun areItemsTheSame(oldItem: Images, newItem: Images): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Images, newItem: Images): Boolean {
            return oldItem == newItem
        }

    }


}