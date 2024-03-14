package mindtech.homework.pokemonassignment.data.repositories

import kotlinx.coroutines.flow.Flow
import mindtech.homework.pokemonassignment.data.entities.PokemonDetails
import mindtech.homework.pokemonassignment.data.entities.PokemonEntityToDatabase

interface PokemonDetailsRepository {
    suspend fun getPokemonByName(name: String): Flow<PokemonDetails>

    suspend fun getCaughtPokemons(): Flow<List<PokemonEntityToDatabase>>

}