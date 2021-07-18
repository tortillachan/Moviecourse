package com.example.myapplication.Data.remote

import com.example.myapplication.Data.model.MovieList
import com.example.myapplication.application.AppConstants
import com.example.myapplication.repository.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies(): MovieList =
        webService.getUpcomingMovies(AppConstants.API_KEY)


    suspend fun getTopRatedMovies(): MovieList =
        webService.geTopRatedMovies(AppConstants.API_KEY)


    suspend fun getPopularMovies(): MovieList =
        webService.getPopularMovies(AppConstants.API_KEY)

}