package mindtech.homework.pokemonassignment.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import mindtech.homework.pokemonassignment.data.dao.PokemonDao
import mindtech.homework.pokemonassignment.data.entities.PokemonDetails
import mindtech.homework.pokemonassignment.data.entities.PokemonEntityToDatabase

@Database(entities = [PokemonEntityToDatabase::class], version = 1, exportSchema = false)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}