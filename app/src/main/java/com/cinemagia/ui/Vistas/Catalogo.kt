package com.cinemagia.ui.Vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cinemagia.Data.Model.Pelicula
import com.cinemagia.Data.ViewModels.ServiceViewModels
import com.cinemagia.R
import com.cinemagia.ui.Vistas.Recursos.CardPelicula
import kotlinx.coroutines.selects.select

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Catalogo(
    onItemClick: (Pelicula) -> Unit,
    vm: ServiceViewModels
) {
    LaunchedEffect(Unit) {
        vm.fetchPeliculas()
    }

    var query by remember { mutableStateOf("") }
    val peliculas = vm.Peliculas.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text("CineMagia")
                        Image(
                            painter = painterResource(id = R.drawable.cinemagia),
                            contentDescription = "Logo",
                            modifier = Modifier.padding(start = 8.dp).size(80.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
//        bottomBar = {
//            NavigationBar {
//                NavigationBarItem()
//                selected = selectedTab == "catalogo",
//                onClick = { seletecTab = "catalogo"},
//                icon={Icon(imageVector = Icons.AutoMirrored.Filled.List, contentDescription = "Cátalogo")},
//                label = {Text("Cátalogo")}
//            }
//            NavigationBar {
//                NavigationBarItem()
//                selected = selectedTab == "favoritas",
//                onClick = { seletecTab = "favoritas"},
//                icon={Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favoritas")},
//                label = {Text("Favoritas")}
//            }
//            NavigationBar {
//                NavigationBarItem()
//                selected = selectedTab == "que ver",
//                onClick = { seletecTab = "que ver"},
//                icon={Icon(imageVector = Icons.Default.Bookmark, contentDescription = "Que Ver")},
//                label = {Text("Que Ver")}
//            }
//        }
    ) { padding ->
        Column(   modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp))
        {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Buscar por título") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(
                    items = peliculas,
                    key = { it.id }
                ) { item ->
                    CardPelicula(
                        pelicula = item,
                        onToggleFavorita = { /* TODO / },
                    onToggleQueVer = { / TODO */ }
                    )
                    // si quieres click:
                    // Modifier.clickable { onItemClick(item) }
                }
            }
        }

    }
}