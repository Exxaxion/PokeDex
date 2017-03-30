package com.shinkiro.exxaxion.pokedex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shinkiro.exxaxion.pokedex.models.Pokemon;
import com.shinkiro.exxaxion.pokedex.models.PokemonStats;
import com.shinkiro.exxaxion.pokedex.pokeapi.PokeapiEndPoint;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Exxaxion on 25/03/2017.
 */

public class PokemonStatsActivity extends AppCompatActivity {

    private static final String TAG = PokemonStatsActivity.class.getSimpleName();
    public static final String EXTRA_POKEMON = "EXTRA_POKEMON";
    private PokeapiEndPoint pokeEndPoint;

    public static Intent newIntent(Context context, Pokemon pokemon) {
        Intent intent = new Intent(context, PokemonStatsActivity.class);
        intent.putExtra(EXTRA_POKEMON, pokemon);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        pokeEndPoint = (PokeapiEndPoint) getApplication().getSystemService(PokeApplication.POKE_ENDPOINT);
        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra(EXTRA_POKEMON);
        getPokeStats(pokemon.getId());

        TextView pokemonName = (TextView) findViewById(R.id.pokemonName);
        pokemonName.setText(pokemon.getName());

        TextView pokeNbr = (TextView) findViewById(R.id.pokemonNumber);
        pokeNbr.setText("Pokemon N° " + pokemon.getId());

        ImageView pokemonPicture = (ImageView) findViewById(R.id.pokemonImage);
        Glide.with(this)
                .load(pokemon.getImageUrl())
                .into(pokemonPicture);
    }

    private void getPokeStats(String pokeId) {
        final LayoutInflater layoutInflater = LayoutInflater.from(this);
        final TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        Call<Pokemon> pokemonResponseCall = pokeEndPoint.getPokemon(pokeId);

        pokemonResponseCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, final Response<Pokemon> response) {
                if (response.isSuccessful()) {

                    final Pokemon pokemon = response.body();
                    for (PokemonStats pokemonStats : pokemon.getStats()) {
                        View row = layoutInflater.inflate(R.layout.stat_row, null);
                        ((TextView) row.findViewById(R.id.label)).setText(pokemonStats.getName());
                        ((TextView) row.findViewById(R.id.value)).setText("" + pokemonStats.getValue());
                        tableLayout.addView(row);
                    }
                } else {
                    Log.e(TAG, " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e(TAG, " onFailure: " + t.getMessage());

            }
        });
    }

}
