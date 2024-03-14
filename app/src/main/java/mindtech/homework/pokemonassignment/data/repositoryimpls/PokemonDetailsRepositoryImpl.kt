package mindtech.homework.pokemonassignment.data.repositoryimpls

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mindtech.homework.pokemonassignment.data.dao.PokemonDao
import mindtech.homework.pokemonassignment.data.entities.PokemonDetails
import mindtech.homework.pokemonassignment.data.entities.PokemonEntityToDatabase
import mindtech.homework.pokemonassignment.data.network.APIService
import mindtech.homework.pokemonassignment.data.repositories.PokemonDetailsRepository

class PokemonDetailsRepositoryImpl(
    val pokemonDao: PokemonDao,
    val apiService: APIService
) : PokemonDetailsRepository {

    override suspend fun getPokemonByName(name: String): Flow<PokemonDetails> {
        return flow {
            val pokemons = apiService.getPokemonByName(name)
            emit(pokemons)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getCaughtPokemons(): Flow<List<PokemonEntityToDatabase>> {
        return pokemonDao.getCaughtPokemons()
    }
}