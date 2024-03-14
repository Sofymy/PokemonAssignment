package mindtech.homework.pokemonassignment.ui.navigation

sealed class Screen(val route: String){
    object PokemonDetails : Screen("PokemonDetails")
    object PokemonList : Screen("PokemonList")
}