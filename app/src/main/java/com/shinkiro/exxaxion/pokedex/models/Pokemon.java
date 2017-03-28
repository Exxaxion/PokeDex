package com.shinkiro.exxaxion.pokedex.models;

import java.io.Serializable;

/**
 * Created by Exxaxion on 24/03/2017.
 */

public class Pokemon implements Serializable {

    private int number;
    private String name;
    private String url;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[] urlParts = url.split("/");
        return Integer.parseInt(urlParts[urlParts.length-1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
