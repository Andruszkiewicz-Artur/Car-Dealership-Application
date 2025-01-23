package com.andruszkiewicz.cardealershipapplication.presentation.adapter.carImages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.andruszkiewicz.cardealershipapplication.R
import com.bumptech.glide.Glide

class CarImagesAdapter() : RecyclerView.Adapter<CarImagesAdapter.ImageViewHolder>() {

    var imagesUrl: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val url = imagesUrl[position]

        Glide.with(holder.itemView.context)
            .load(url)
            .placeholder(R.drawable.ic_image_gray)
            .error(R.drawable.ic_image_gray)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return imagesUrl.size
    }
}