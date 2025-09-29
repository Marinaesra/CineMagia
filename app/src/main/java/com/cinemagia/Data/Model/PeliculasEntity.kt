package com.cinemagia.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Peliculas")
data class PeliculaEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val image: String,
    val trailer: String,
)
    data class Pelicula(
        val id: String,
        val title: String,
        val description: String,
        val image: String,
        val trailer: String,

    )

fun Pelicula.toEntity() = PeliculaEntity(
    id = this.id,
    title = this.title,
    description = this.description,
    image = this.image,
    trailer = this.trailer
)