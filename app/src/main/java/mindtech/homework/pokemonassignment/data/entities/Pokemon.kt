package mindtech.homework.pokemonassignment.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


data class PokemonEntity(
    @PrimaryKey
    val name: String = "",
    val url: String = "",
)

data class Pokemon (
    val pokemon: PokemonEntity,
    val slot: Long = 0
)

@Entity(tableName = "pokemons")
data class PokemonEntityToDatabase (
    @PrimaryKey
    val name: String = ""
)


data class PokemonDetails (
    val abilities: Any? = null,
    val baseExperience: Any? = null,
    val cries: Any? = null,
    val forms: Any? = null,
    val gameIndices: Any? = null,
    val height: Long,
    val heldItems: Any? = null,
    val id: Any? = null,
    val isDefault: Any? = null,
    val locationAreaEncounters: Any? = null,
    val moves: Any? = null,
    val name: String = "",
    val order: Any? = null,
    val pastAbilities: Any? = null,
    val pastTypes: Any? = null,
    val species: Any? = null,
    val sprites: Any? = null,
    val stats: Any? = null,
    val types: Any? = null,
    val weight: Long = 0
)


