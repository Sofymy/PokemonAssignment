package mindtech.homework.pokemonassignment.data.repositoryimpls

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mindtech.homework.pokemonassignment.data.dao.PokemonDao
import mindtech.homework.pokemonassignment.data.entities.PokemonDetails
import mindtech.homework.pokemonassignment.data.entities.PokemonEntityToDatabase
import mindtech.homework.pokemonassignment.data.entities.Types
import mindtech.homework.pokemonassignment.data.network.APIService
import mindtech.homework.pokemonassignment.data.repositories.PokemonListRepository

class PokemonListRepositoryImpl(
    private val pokemonDao: PokemonDao,
    private val apiService: APIService
) : PokemonListRepository {
    override suspend fun getPokemonsByTypeId(typeId: String): Flow<Array<PokemonDetails>> {
        return flow {
            var pokemons = emptyArray<PokemonDetails>()
            val result = apiService.getPokemonsByTypeId(typeId)
            for(pokemon in result.pokemon){
                val pok = apiService.getPokemonByUrl(pokemon.pokemon.url.substringAfter("pokemon/"))
                Log.d("eeeeeeee", pok.toString())
                pokemons += pok
            }
            emit(pokemons)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getPokemonByName(name: String): Flow<PokemonDetails> {
        return flow {
            val pokemons = apiService.getPokemonByName(name)
            emit(pokemons)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getTypes(): Flow<Types> {
        return flow {
            val result = apiService.getTypes()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun insert(pokemon: PokemonDetails){
        pokemonDao.insert(PokemonEntityToDatabase(pokemon.name))
    }
    override fun delete(pokemon: PokemonDetails) {
        pokemonDao.delete(PokemonEntityToDatabase(pokemon.name))
    }

    override suspend fun getCatchedPokemons(): Flow<List<PokemonEntityToDatabase>> {
        return pokemonDao.getCaughtPokemons()
    }
}