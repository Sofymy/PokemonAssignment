package mindtech.homework.pokemonassignment.data.database

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import mindtech.homework.pokemonassignment.data.dao.PokemonDao
import mindtech.homework.pokemonassignment.data.entities.Pokemon

@RequiresApi(Build.VERSION_CODES.O)
@Database(entities = [Pokemon::class], version = 1, exportSchema = false)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}