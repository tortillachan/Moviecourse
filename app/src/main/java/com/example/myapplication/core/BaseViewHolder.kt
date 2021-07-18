package com.example.myapplication.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T> (itemView: View): RecyclerView.ViewHolder(itemView){
    abstract fun bind(item: T)
}

//viewholder para adapter