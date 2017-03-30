package com.shinkiro.exxaxion.pokedex.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Exxaxion on 24/03/2017.
 */

public class Pokemon implements Serializable {

    private String name;
    private String url;
    private List<PokemonStats> stats;
    final String imgPokemon = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imgPokemon + getId() + ".png";
    }

    public String getId() {
        String[] urlParts = url.split("/");
        return urlParts[urlParts.length - 1];
    }

    public List<PokemonStats> getStats() {
        return stats;
    }
}
