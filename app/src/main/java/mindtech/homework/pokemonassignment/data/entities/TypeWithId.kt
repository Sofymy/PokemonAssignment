package mindtech.homework.pokemonassignment.data.entities

data class TypeWithId (
    val damageRelations: Any? = null,
    val gameIndices: Any? = null,
    val generation: Any? = null,
    val id: Long = 0,
    val moveDamageClass: Any? = null,
    val moves: Any? = null,
    val name: String = "",
    val names: Any? = null,
    val pastDamageRelations: Any? = null,
    val pokemon: List<Pokemon> = emptyList(),
)
