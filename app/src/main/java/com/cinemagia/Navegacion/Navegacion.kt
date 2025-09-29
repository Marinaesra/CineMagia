package com.cinemagia.Navegacion

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CineMagiaNav() {
    val navController = rememberNavController()
    val vm: ServiceViewModels = viewModel()
    val scope = rememberCoroutineScope()

    NavHost(navController, startDestination = "login") {
        composable("login") {
            Login(
                onItemClick = { email, password ->
                    scope.launch {
                        val ok = vm.logearse(email, password)
                        if (ok) {
                            vm.fetchPeliculas()
                            navController.navigate("catalogo") {
                                popUpTo("login")
                            }
                        } else {
                            Log.e("Error Login", "Email o contraseña incorrectos")
                        }
                    }
                },
                onItemRegistre = { navController.navigate("registro") })

        }
        composable("catalogo") {
            Catalogo(
                onItemClick = { navController.navigate("detalles") },
                onIntemFavorita = { navController.navigate("favoritas") },
                onIntemQueVer = { navController.navigate("favoritas") }, vm
            )
        }
        composable("registro") {
            Registro(onItemClick = { email, password ->
                scope.launch {
                    vm.registroUsuario(email, password)
                    navController.navigate("catalogo")
                    { popUpTo("registro") }
                }

            })
        }

        composable("detalles") {
            Detalles(onItemClick = { })
        }

        composable("favorita") {
            Favoritas(onItemClick = { })
        }

        composable("queVer") {
            QueVer(onItemClick = { })
        }


    }
}