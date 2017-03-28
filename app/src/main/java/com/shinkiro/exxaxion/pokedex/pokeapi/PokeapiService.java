package com.shinkiro.exxaxion.pokedex.pokeapi;

import com.shinkiro.exxaxion.pokedex.models.PokemonResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Exxaxion on 24/03/2017.
 */

public interface PokeapiService {

    @GET("pokemon")
    Call<PokemonResponse> obtenerListPokemon(@Query("limit") int limit, @Query("offset") int offset);

}
