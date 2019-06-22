package com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.model.PhotosModel
import litmus7.com.kotlinbasicappwithretrofitlivedataandviewmodel.R

class PhotosListCustomAdapter(val data: List<PhotosModel>,val context : Context) :
    RecyclerView.Adapter<PhotosListCustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.photos_custom_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataItemText.text = data[position].title
        val requestOptions = RequestOptions().fitCenter()
        Glide.with(context).load(data[position].thumbnailUrl).apply(requestOptions)
            .into(holder.dataItemimage)
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dataItemText: TextView = itemView.findViewById(R.id.title)
        val dataItemimage: ImageView = itemView.findViewById(R.id.coverImage)
    }
}