package com.shinkiro.exxaxion.pokedex.models;

import java.util.ArrayList;

/**
 * Created by Exxaxion on 28/03/2017.
 */

public class PokemonStatsResponse {

    private ArrayList<PokemonStatsDetails> statsDetails;

    public ArrayList<PokemonStatsDetails> getStatsDetails() {
        return statsDetails;
    }

    public void setStatsDetails(ArrayList<PokemonStatsDetails> statsDetails) {
        this.statsDetails = statsDetails;
    }
}
