package com.example.myapplication.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import com.example.myapplication.Data.model.Movie
import com.example.myapplication.Data.remote.MovieDataSource
import com.example.myapplication.R
import com.example.myapplication.ViewModel.ViewModel
import com.example.myapplication.ViewModel.ViewModelFactory
import com.example.myapplication.core.Resource
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.repository.RetrofitClient
import com.example.myapplication.repository.dataRepoImplements
import com.example.myapplication.ui.adapters.MovieAdapter
import com.example.myapplication.ui.adapters.concatadapter.PopularConcatAdapter
import com.example.myapplication.ui.adapters.concatadapter.TopRatedConcatAdapter
import com.example.myapplication.ui.adapters.concatadapter.UpcomingConcatAdapter

class HomeFragment : Fragment(R.layout.fragment_home), MovieAdapter.OnMovieClickListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<ViewModel> { ViewModelFactory(dataRepoImplements(
        MovieDataSource(RetrofitClient.webService)
    )
    )
    }
    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        concatAdapter = ConcatAdapter()

        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        concatAdapter.apply {
                            addAdapter(0, UpcomingConcatAdapter(MovieAdapter(result.data.first.result, this@HomeFragment)))

                            addAdapter(1, TopRatedConcatAdapter(MovieAdapter(result.data.second.result, this@HomeFragment)))

                            addAdapter(2, PopularConcatAdapter(MovieAdapter(result.data.third.result, this@HomeFragment)))
                        }

                        binding.Recyclerhome.adapter = concatAdapter
                }

                    is Resource.Failure ->{
                    Log.d("LiveData", "${result.exception}")
                }
            }
        } )




    }

    override fun onMovieClick(movie: Movie) {
        Log.d("Movie", "onMovieClick: $movie")
    }
}