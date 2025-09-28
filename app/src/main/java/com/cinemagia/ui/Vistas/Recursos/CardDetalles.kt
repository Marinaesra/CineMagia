package com.cinemagia.ui.Vistas.Recursos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cinemagia.Data.Model.Pelicula

@Composable
fun CardDetalles(pelicula: Pelicula,
                 onToggleFavorita: () -> Unit,
                 onToggleQueVer: () -> Unit,){
    val favorita by remember{mutableStateOf(false)}
    val queVer by remember{mutableStateOf(false)}

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = pelicula.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                )
                if (pelicula.description.isNotBlank()) {
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = pelicula.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(Modifier.height(8.dp))

                if (pelicula.image.isNotBlank()){
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = pelicula.image,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(Modifier.height(8.dp))

                if (pelicula.trailer.isNotBlank()) {
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = pelicula.trailer,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    IconButton(onClick = onToggleFavorita) {
                        if (favorita) {
                            Icon(Icons.Filled.Favorite, contentDescription = "Quitar de favoritos", tint = MaterialTheme.colorScheme.primary)
                        } else {
                            Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Añadir a favoritos")
                        }
                    }
                    IconButton(onClick = onToggleQueVer) {
                        if (queVer) {
                            Icon(Icons.Filled.Bookmark, contentDescription = "Quitar de que Ver", tint = MaterialTheme.colorScheme.primary)
                        } else {
                            Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Añadir a que Ver")
                        }
                    }
                }
            }
        }
    }

}