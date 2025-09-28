package com.cinemagia.Data.Repository

import com.cinemagia.Data.API.ApiApp
import com.cinemagia.Data.Model.Pelicula


class ServiceRepository {
    private val api = ApiApp.api

    suspend fun fetchPeliculas():List<Pelicula>{
        val lista= api.getMovies()
        return lista
    }

}