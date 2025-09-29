package com.cinemagia.Data.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.cinemagia.Data.Model.Pelicula


@Dao
    interface PeliculaDao {

        @Query("SELECT * FROM Peliculas")
        fun getMovies(): LiveData<List<Pelicula>>

    }
