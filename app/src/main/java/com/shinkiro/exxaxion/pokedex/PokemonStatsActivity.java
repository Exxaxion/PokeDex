package com.shinkiro.exxaxion.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.shinkiro.exxaxion.pokedex.models.Pokemon;


/**
 * Created by Exxaxion on 25/03/2017.
 */

public class PokemonStatsActivity  extends AppCompatActivity {

    private int position;
    private int pokemonNumber;
    public static final String IMG_URL = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_stat_item);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        position = extras.getInt("SOME_ID");

        if (extras != null) {

            Toast.makeText(PokemonStatsActivity.this, "Current position is  " + position, Toast.LENGTH_SHORT).show();

        }

        Pokemon pokemon = (Pokemon)getIntent().getExtras().get("NAME");
        TextView pokemonName = (TextView) findViewById(R.id.pokemonName);
        pokemonName.setText(pokemon.getName());

        ImageView pokemonPicture = (ImageView) findViewById(R.id.pokemonImage);
        String imgPokemon = extras.getString(IMG_URL);

        pokemonNumber = position+=1;
        TextView pokeNbr = (TextView) findViewById(R.id.pokemonNumber);
        pokeNbr.setText("Pokemon N° " +pokemonNumber);

        Glide.with(this)
                .load(imgPokemon)
                .into(pokemonPicture);

    }
}
