package com.shinkiro.exxaxion.pokedex.pokeapi;

import com.shinkiro.exxaxion.pokedex.models.Pokemon;
import com.shinkiro.exxaxion.pokedex.models.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Exxaxion on 24/03/2017.
 */

public interface PokeapiEndPoint {

    @GET("pokemon")
    Call<PokemonResponse> listPokemons(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") String pokeId);
}
