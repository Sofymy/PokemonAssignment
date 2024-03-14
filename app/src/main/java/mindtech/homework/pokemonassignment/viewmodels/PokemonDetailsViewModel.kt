package mindtech.homework.pokemonassignment.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import mindtech.homework.pokemonassignment.data.entities.PokemonDetails
import mindtech.homework.pokemonassignment.data.entities.PokemonEntityToDatabase
import mindtech.homework.pokemonassignment.data.repositories.PokemonDetailsRepository
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val pokemonDetailsRepository: PokemonDetailsRepository
): ViewModel() {

    private val _result = MutableStateFlow(PokemonDetails())
    val result = _result.asStateFlow()
    fun getPokemonByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonDetailsRepository.getPokemonByName(name).collectLatest {
                _result.tryEmit(it)
            }
        }
    }

    private val _caughtPokemons = MutableStateFlow(emptyList<PokemonEntityToDatabase>())
    val caughtPokemons = _caughtPokemons.asStateFlow()

    fun getCaughtPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonDetailsRepository.getCaughtPokemons().collectLatest {
                _caughtPokemons.tryEmit(it)
            }
        }
    }
}