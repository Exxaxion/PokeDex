package com.shinkiro.exxaxion.pokedex.models;

import java.util.ArrayList;

/**
 * Created by Exxaxion on 24/03/2017.
 */

public class PokemonResponse {

    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
