package mindtech.homework.pokemonassignment.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Types (
    val count: Long,
    val next: Any? = null,
    val previous: Any? = null,
    val results: List<Type>
)
@Entity(tableName = "types")
data class Type(
    @PrimaryKey
    val name: String = "",
    val url: String = "",
)