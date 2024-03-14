package mindtech.homework.pokemonassignment.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mindtech.homework.pokemonassignment.ui.screen.PokemonDetailsScreen
import mindtech.homework.pokemonassignment.ui.screen.PokemonListScreen

@Composable
fun Navigation(
    navController: NavHostController
){
    NavHost(navController, startDestination = Screen.PokemonList.route) {
        composable(Screen.PokemonList.route) {
            PokemonListScreen {
                navController.navigate(Screen.PokemonDetails.route + "/${it}")
            }
        }
        composable(Screen.PokemonDetails.route + "/{name}") {
            val name = it.arguments?.getString("name")
            PokemonDetailsScreen(
                name = name
            )
        }
    }
}