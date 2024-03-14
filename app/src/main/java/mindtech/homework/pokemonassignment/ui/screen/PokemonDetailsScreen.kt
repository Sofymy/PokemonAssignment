package mindtech.homework.pokemonassignment.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import mindtech.homework.pokemonassignment.data.entities.PokemonDetails
import mindtech.homework.pokemonassignment.viewmodels.PokemonDetailsViewModel

@Composable
fun PokemonDetailsScreen(
    name: String?,
    viewModel: PokemonDetailsViewModel = hiltViewModel(),
){

    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit){
        if (name != null) {
            viewModel.getPokemonByName(name)
        }
    }

    PokemonDetailsScreenContent(
        viewModel,
        onCatchClicked = {
            scope.launch{
                //TO DO
            }
        },
        onReleaseClicked = {
            scope.launch{
                //TO DO
            }
        }
    )

}

@Composable
fun PokemonDetailsScreenContent(
    viewModel: PokemonDetailsViewModel,
    onCatchClicked: (PokemonDetails) -> Unit,
    onReleaseClicked: (PokemonDetails) -> Unit
) {
    viewModel.getCaughtPokemon()

    val pokemon by viewModel.result.collectAsStateWithLifecycle()
    val caughtPokemons by viewModel.caughtPokemons.collectAsStateWithLifecycle()

    val isCaught = mutableStateOf(false)
    for(caught in caughtPokemons){
        if (pokemon.name == caught.name){
            isCaught.value = true
        }
    }

    Column {
        Text("Name: " + pokemon.name)
        Text("Weight: " + pokemon.weight + "kg")
        Text("Height: " + pokemon.height + "m")
        Text("Abilities: " + pokemon.abilities)

        Button(
            modifier = Modifier.background(
                if(isCaught.value) Color.Yellow
                else Color.Blue
            ),
            onClick = {
                if(isCaught.value) onReleaseClicked(pokemon)
                else{
                    onCatchClicked(pokemon)
                    isCaught.value = true
                }
            }
        ){
            Text(
                text= if(isCaught.value) {
                    "Release"
                } else "Catch"
            )
        }
    }
}
