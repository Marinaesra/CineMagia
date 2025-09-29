package com.cinemagia.Data.Repository

import com.cinemagia.Data.API.ApiApp
import com.cinemagia.Data.Model.CreateRequest
import com.cinemagia.Data.Model.Pelicula
import com.cinemagia.Data.Model.UserMovie
import com.cinemagia.Data.Model.Usuario


class ServiceRepository {
    private val api = ApiApp.api

    suspend fun fetchPeliculas():List<Pelicula>{
        val lista= api.getMovies()
        return lista
    }

    suspend fun fetchPelicula(id: String){
        api.getMovie(id)
    }

    suspend fun fetchUsuarios():List<Usuario>{
        val resp = api.getUser()
        return resp
    }

    suspend fun registroUsuario(email: String, password: String, movies:List<UserMovie>?): Usuario{
        val create = api.createUser(CreateRequest(email, password, movies))
        return create
    }
}