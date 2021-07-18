package com.example.myapplication.ui.adapters.concatadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.core.BaseConcatHolder
import com.example.myapplication.databinding.RowBinding
import com.example.myapplication.databinding.UpcomingMovieRowBinding
import com.example.myapplication.ui.adapters.MovieAdapter

class UpcomingConcatAdapter(private val moviesAdapter: MovieAdapter):
    RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = UpcomingMovieRowBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(moviesAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private  inner class ConcatViewHolder(val  binding: UpcomingMovieRowBinding): BaseConcatHolder<MovieAdapter>(binding.root){
        override fun bind(adapter: MovieAdapter){
            binding.rvUpcomingMovies.adapter = adapter
        }
    }
}
