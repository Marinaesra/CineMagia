package com.cinemagia.Navegacion

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cinemagia.Data.ViewModels.ServiceViewModels
import com.cinemagia.ui.Vistas.Catalogo
import com.cinemagia.ui.Vistas.Detalles
import com.cinemagia.ui.Vistas.Favoritas
import com.cinemagia.ui.Vistas.Login
import com.cinemagia.ui.Vistas.QueVer
import com.cinemagia.ui.Vistas.Registro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CineMagiaNav() {
    val navController = rememberNavController()
    val vm: ServiceViewModels = viewModel ()

    NavHost(navController, startDestination = "Login") {
        composable("login") {
            Login(onItemClick = { navController.navigate("catalogo")},
            onItemRegistre = {navController.navigate("registro")})

        }
        composable("catalogo") {
            Catalogo(onItemClick = { } )
        }
        composable("registro") {
            Registro (onItemClick = { navController.navigate("catalogo")} )
        }

        composable("detalles") {
            Detalles(onItemClick = { } )
        }

        composable("favorita") {
            Favoritas(onItemClick = { } )
        }

        composable("queVer") {
            QueVer(onItemClick = { } )
        }




    }
}