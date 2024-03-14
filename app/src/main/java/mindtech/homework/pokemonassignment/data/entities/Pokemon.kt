package mindtech.homework.pokemonassignment.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class Pokemon(
    @PrimaryKey
    val id: Long,
    val name: String,
)

@Entity(tableName = "types")
data class Type(
    @PrimaryKey
    val name: String,
    val url: String,
)

