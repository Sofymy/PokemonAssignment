package mindtech.homework.pokemonassignment.data.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import mindtech.homework.pokemonassignment.data.entities.Pokemon

@Dao
interface PokemonDao {
    @Query("SELECT * " +
            "FROM pokemons")
    fun getPokemons(): Flow<List<Pokemon>>
}