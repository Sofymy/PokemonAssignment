package mindtech.homework.pokemonassignment.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mindtech.homework.pokemonassignment.data.repositories.PokemonDetailsRepository
import mindtech.homework.pokemonassignment.data.repositories.PokemonListRepository
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonListRepository: PokemonListRepository
): ViewModel() {

}