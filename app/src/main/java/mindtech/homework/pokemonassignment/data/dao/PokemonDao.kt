package mindtech.homework.pokemonassignment.data.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface PokemonDao {
    @Query("SELECT *" +
            "FROM pokemons")
    fun getPokemons()
}