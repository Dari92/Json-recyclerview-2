package com.kotlincourse.jr2.PhotoAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlincourse.jr2.Model.Photos
import com.kotlincourse.jr2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_photos_item.view.*

class PhotoAdapter(private val context: Context, private val photoList: MutableList<Photos>) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>(){


    class PhotoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var v_id: TextView
        var v_name: TextView
        var v_description: TextView
        var v_image: ImageView

        init {
            v_id = itemView.idPhoto
            v_name = itemView.namePhoto
            v_description = itemView.descriptionPhoto
            v_image = itemView.imageViewPhoto
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_photos_item, parent, false)
        return PhotoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.v_id.text = photoList[position].id.toString()
        holder.v_name.text = photoList[position].photoName
        holder.v_description.text = photoList[position].photoDescription
        Picasso.get().load(photoList[position].urlPhoto).into(holder.v_image)
    }
}