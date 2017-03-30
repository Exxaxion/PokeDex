package com.shinkiro.exxaxion.pokedex;

import android.app.Application;

import com.shinkiro.exxaxion.pokedex.pokeapi.PokeapiEndPoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PokeApplication extends Application {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/";
    private PokeapiEndPoint endPoint;
    static final String POKE_ENDPOINT = "POKE_ENDPOINT";

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        endPoint = retrofit.create(PokeapiEndPoint.class);
    }

    @Override
    public Object getSystemService(String name) {
        if (POKE_ENDPOINT.equals(name)) {
            return endPoint;
        }
        return super.getSystemService(name);
    }
}
