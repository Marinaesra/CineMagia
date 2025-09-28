package com.cinemagia.Data.ViewModels

import androidx.lifecycle.ViewModel
import com.cinemagia.Data.Model.Pelicula
import com.cinemagia.Data.Repository.ServiceRepository
import kotlinx.coroutines.flow.MutableStateFlow

class ServiceViewModels(private val repo: ServiceRepository = ServiceRepository())
    : ViewModel()
{
val Peliculas = MutableStateFlow<List<Pelicula>>(emptyList())

    suspend fun fetchPeliculas(){
        Peliculas.value = repo.fetchPeliculas()
    }
}

