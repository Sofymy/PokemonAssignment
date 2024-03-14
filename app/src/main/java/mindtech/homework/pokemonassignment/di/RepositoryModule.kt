package mindtech.homework.pokemonassignment.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mindtech.homework.pokemonassignment.data.dao.PokemonDao
import mindtech.homework.pokemonassignment.data.network.APIService
import mindtech.homework.pokemonassignment.data.repositories.PokemonDetailsRepository
import mindtech.homework.pokemonassignment.data.repositories.PokemonListRepository
import mindtech.homework.pokemonassignment.data.repositoryimpls.PokemonDetailsRepositoryImpl
import mindtech.homework.pokemonassignment.data.repositoryimpls.PokemonListRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providePokemonListRepository(
        pokemonDao: PokemonDao,
        apiService: APIService
    ): PokemonListRepository = PokemonListRepositoryImpl(pokemonDao, apiService)

    @Provides
    fun providePokemonDetailsRepository(
        pokemonDao: PokemonDao,
        apiService: APIService
    ): PokemonDetailsRepository = PokemonDetailsRepositoryImpl(pokemonDao, apiService)

}
