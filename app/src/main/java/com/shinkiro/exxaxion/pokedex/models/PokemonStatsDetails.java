package com.shinkiro.exxaxion.pokedex.models;

/**
 * Created by Exxaxion on 28/03/2017.
 */

public class PokemonStatsDetails {

    private int base_stat;

    public PokemonStatsDetails(int base_stat) {
        this.base_stat = base_stat;
    }

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }
}
