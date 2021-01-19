package com.profitmobile.android.photogallery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.profitmobile.android.photogallery.GalleryItem
import com.profitmobile.android.photosearch.R
import kotlinx.android.synthetic.main.list_item_gallery.view.*

class PhotoAdapter(val context: Context): ListAdapter<GalleryItem, PhotoAdapter.PhotoViewHolder>(PhotoAdapterDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_gallery, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val galleryItem = getItem(position)
        with(holder){
            Glide
                .with(context)
                .load(galleryItem.url)
                .placeholder(R.drawable.we)
                .into(image);
        }

    }

    inner class PhotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.item_image_view)
    }
}


private class PhotoAdapterDiffCallBack: DiffUtil.ItemCallback<GalleryItem>() {
    override fun areItemsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
       return oldItem.id  == newItem.id
    }

    override fun areContentsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
        return oldItem == newItem
    }
}