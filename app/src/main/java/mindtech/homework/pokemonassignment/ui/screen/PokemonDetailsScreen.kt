package mindtech.homework.pokemonassignment.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import mindtech.homework.pokemonassignment.viewmodels.PokemonDetailsViewModel

@Composable
fun PokemonDetailsScreen(
    name: String? = null
){
    name?.let { Text(it) }
}