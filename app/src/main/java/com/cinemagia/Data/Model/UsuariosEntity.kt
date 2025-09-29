package com.cinemagia.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Usuarios")
data class UsuarioEntity(
    @PrimaryKey val id: String,
    val email: String,
    val password: String,
    val movies: List<UserMovie>
)
data class Usuario(
    val id: String,
    val email: String,
    val password: String,
    val movies: List<UserMovie>
    )

fun Usuario.toEntity() = UsuarioEntity(
    id = this.id,
    email = this.email,
    password = this.password,
    movies = this.movies
)

data class UserMovie(
    val movieId: String,
    val favorite: Boolean,
    val watchlist: Boolean
)

data class CreateRequest(
    val email: String,
    val password: String,
    val movies: List<UserMovie>?
)
