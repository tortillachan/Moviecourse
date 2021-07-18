package com.example.myapplication.repository

import com.example.myapplication.Data.model.MovieList

interface dataRepo {
    suspend fun getUpcomingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
}