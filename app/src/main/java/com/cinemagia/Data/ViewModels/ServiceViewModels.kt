package com.cinemagia.Data.ViewModels

import android.provider.ContactsContract
import androidx.lifecycle.ViewModel
import com.cinemagia.Data.Model.Pelicula
import com.cinemagia.Data.Model.UserMovie
import com.cinemagia.Data.Model.Usuario
import com.cinemagia.Data.Repository.ServiceRepository
import kotlinx.coroutines.flow.MutableStateFlow

class ServiceViewModels(private val repo: ServiceRepository = ServiceRepository())
    : ViewModel() {
    val Peliculas = MutableStateFlow<List<Pelicula>>(emptyList())
    val Usuarios = MutableStateFlow<List<Usuario>>(emptyList())

    suspend fun fetchPeliculas() {
        Peliculas.value = repo.fetchPeliculas()
    }

    suspend fun logearse(email: String, password: String): Boolean {
        val all = repo.fetchUsuarios()
        Usuarios.value = all
        val found = all.find { it.email.equals(email, ignoreCase = true) }
        val ok = if (found != null && (found.password == password)) {
            true
        } else {
            false
        }
        return ok
    }


    suspend fun registroUsuario(email: String, password: String) {
        val catalogo = repo.fetchPeliculas()
        val defaults =
            catalogo.map { m -> UserMovie(movieId = m.id, favorite = false, watchlist = false) }
        repo.registroUsuario(email, password, defaults)
    }
}
