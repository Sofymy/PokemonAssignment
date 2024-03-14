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
import mindtech.homework.pokemonassignment.data.entities.Type
import mindtech.homework.pokemonassignment.data.repositories.PokemonListRepository
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonListRepository: PokemonListRepository
): ViewModel() {

    private val _typeList = MutableStateFlow(emptyList<Type>())
    val typeList = _typeList.asStateFlow()

    fun getTypes() {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonListRepository.getTypes().collectLatest {
                _typeList.tryEmit(it.results)
            }
        }
    }

    private val _result = MutableStateFlow(emptyArray<PokemonDetails>())
    val result = _result.asStateFlow()
    fun getPokemonsByTypeId(type: Type) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonListRepository.getPokemonsByTypeId(substring(type.url)).collectLatest {
                _result.tryEmit(it)
            }
        }
    }

    private fun substring(string: String): String {
        return string.substringAfter("type/")
    }

    fun getPokemonsByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonListRepository.getPokemonByName(name).collectLatest {
                _result.tryEmit(arrayOf(it))
            }
        }
    }

    suspend fun insert(pokemon: PokemonDetails) {
        pokemonListRepository.insert(pokemon)
    }

    suspend fun delete(pokemon: PokemonDetails) {
        pokemonListRepository.delete(pokemon)
    }


    private val _caughtPokemons = MutableStateFlow(emptyList<PokemonEntityToDatabase>())
    val caughtPokemons = _caughtPokemons.asStateFlow()

    fun getCaughtPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonListRepository.getCaughtPokemons().collectLatest {
                _caughtPokemons.tryEmit(it)
            }
        }
    }

}