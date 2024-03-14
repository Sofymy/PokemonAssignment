package mindtech.homework.pokemonassignment.data.network

import mindtech.homework.pokemonassignment.data.entities.Type
import mindtech.homework.pokemonassignment.data.entities.Type2
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("type")
    fun getTypes() : List<Type2>
}