package com.shinkiro.exxaxion.pokedex.models;


/**
 * Created by Exxaxion on 24/03/2017.
 */

public class PokemonStats {

    private Pokemon pokemon;
    private String url;
    private String type;
    private int speed;
    private int special_defense;
    private int special_attack;
    private int defense;
    private int attack;
    private int hp;

    public PokemonStats(Pokemon pokemon, String type, int speed, int special_defense, int special_attack, int defense, int attack, int hp) {
        this.pokemon = pokemon;
        this.type = type;
        this.speed = speed;
        this.special_defense = special_defense;
        this.special_attack = special_attack;
        this.defense = defense;
        this.attack = attack;
        this.hp = hp;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpecial_defense() {
        return special_defense;
    }

    public void setSpecial_defense(int special_defense) {
        this.special_defense = special_defense;
    }

    public int getSpecial_attack() {
        return special_attack;
    }

    public void setSpecial_attack(int special_attack) {
        this.special_attack = special_attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
