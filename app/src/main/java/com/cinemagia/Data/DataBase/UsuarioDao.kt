package com.cinemagia.Data.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.cinemagia.Data.Model.Pelicula
import com.cinemagia.Data.Model.Usuario


@Dao
interface UsuarioDao {

    @Query("SELECT * FROM Usuarios")
    fun getUser(): LiveData<List<Usuario>>

}