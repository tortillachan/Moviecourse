package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.myapplication.core.Resource
import com.example.myapplication.repository.dataRepo
import kotlinx.coroutines.Dispatchers

class ViewModel(private val repo:dataRepo): ViewModel() {

    fun fetchMainScreenMovies() = liveData(Dispatchers.IO){
        emit(Resource.Loading())

        try {
            emit(Resource.Success(Triple(repo.getUpcomingMovies(),repo.getTopRatedMovies(),repo.getPopularMovies())))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}

class ViewModelFactory(private val repo: dataRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(dataRepo::class.java).newInstance(repo)
    }
}