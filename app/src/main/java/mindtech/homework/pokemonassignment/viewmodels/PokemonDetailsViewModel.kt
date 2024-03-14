package mindtech.homework.pokemonassignment.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mindtech.homework.pokemonassignment.data.repositories.PokemonDetailsRepository
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val pokemonDetailsRepository: PokemonDetailsRepository
): ViewModel() {


}