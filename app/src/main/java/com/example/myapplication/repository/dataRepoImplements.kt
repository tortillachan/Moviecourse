package com.example.myapplication.repository

import com.example.myapplication.Data.model.MovieList
import com.example.myapplication.Data.remote.MovieDataSource

class dataRepoImplements(private val dataSource: MovieDataSource): dataRepo {

    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()
}