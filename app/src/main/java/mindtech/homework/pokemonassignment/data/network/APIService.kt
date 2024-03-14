package mindtech.homework.pokemonassignment.data.network

import mindtech.homework.pokemonassignment.data.entities.PokemonDetails
import mindtech.homework.pokemonassignment.data.entities.Type
import mindtech.homework.pokemonassignment.data.entities.TypeWithId
import mindtech.homework.pokemonassignment.data.entities.Types
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("type")
    suspend fun getTypes() : Types

    @GET("type/{typeId}")
    suspend fun getPokemonsByTypeId(@Path("typeId") name: String): TypeWithId
    @GET("pokemon/{typeId}")
    suspend fun getPokemonByUrl(@Path("typeId") name: String): PokemonDetails

    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name: String): PokemonDetails
}