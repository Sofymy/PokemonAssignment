package mindtech.homework.pokemonassignment.data.repositories

import kotlinx.coroutines.flow.Flow
import mindtech.homework.pokemonassignment.data.entities.PokemonDetails
import mindtech.homework.pokemonassignment.data.entities.PokemonEntityToDatabase
import mindtech.homework.pokemonassignment.data.entities.Types

interface PokemonListRepository {

    suspend fun getTypes(): Flow<Types>
    suspend fun getPokemonsByTypeId(typeId: String): Flow<Array<PokemonDetails>>
    suspend fun getPokemonByName(name: String): Flow<PokemonDetails>
    suspend fun insert(pokemon: PokemonDetails)
    suspend fun getCaughtPokemons(): Flow<List<PokemonEntityToDatabase>>
    suspend fun delete(pokemon: PokemonDetails)

}