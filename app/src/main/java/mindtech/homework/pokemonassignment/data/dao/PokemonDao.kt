package mindtech.homework.pokemonassignment.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import mindtech.homework.pokemonassignment.data.entities.PokemonEntityToDatabase

@Dao
interface PokemonDao {
    @Query("SELECT * " +
            "FROM pokemons")
    fun getCaughtPokemons(): Flow<List<PokemonEntityToDatabase>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pokemon: PokemonEntityToDatabase)

    @Delete
    suspend fun delete(pokemon: PokemonEntityToDatabase)
}