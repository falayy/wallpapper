package com.example.wallpaperr.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperr.R

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.viewpager_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = Int.MAX_VALUE


    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {

        when (position) {
            0 -> holder.imageView.setImageResource(R.drawable.view_pager_1)
            1 -> holder.imageView.setImageResource(R.drawable.view_pager_2)
            2 -> holder.imageView.setImageResource(R.drawable.view_pager_3)
        }
    }
}


class ViewPagerViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView = itemView.findViewById(R.id.image_view_pager)
    var textView: TextView = itemView.findViewById(R.id.text_view_pager)

}
