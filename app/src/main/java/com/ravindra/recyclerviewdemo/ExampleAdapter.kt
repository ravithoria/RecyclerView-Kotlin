package com.ravindra.recyclerviewdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ravindra.recyclerviewdemo.response.user.ResultsItem

class ExampleAdapter(private val userList: List<ResultsItem>) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_row,
            parent,
            false
        )
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.textView.text = currentItem.email
        Log.d("TAG", "DATA:: " + currentItem.location?.street?.name)
        //holder.textView.text = currentItem.results?.get(0)?.email
        Glide.with(holder.itemView.context).load(currentItem.picture?.thumbnail).into(holder.imageView)
        holder.tvCity.text = currentItem.location?.street?.name
    }

    override fun getItemCount() = userList.size

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tv_item_name)
        val imageView: ImageView = itemView.findViewById(R.id.pic)
        val tvCity: TextView = itemView.findViewById(R.id.tv_item_city)
    }
}