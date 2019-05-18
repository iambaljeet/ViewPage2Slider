package com.example.app.viewpage2slider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.image_slider_list_item.view.*

class ImageSliderAdapter(
        var colorList: MutableList<Int>): RecyclerView.Adapter<ImageSliderAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.image_slider_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return colorList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val colorCode: Int = colorList[position]

        holder.imageView.setBackgroundResource(colorCode)
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.imageView
    }
}