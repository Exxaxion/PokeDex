package com.shinkiro.exxaxion.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.shinkiro.exxaxion.pokedex.models.Pokemon;
import com.shinkiro.exxaxion.pokedex.models.PokemonResponse;
import com.shinkiro.exxaxion.pokedex.pokeapi.PokeapiService;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Exxaxion on 24/03/2017.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "POKEDEX";
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private ListPokemonAdapter listPokemonAdapter;
    private int offset;
    private boolean ableToLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listPokemonAdapter = new ListPokemonAdapter(this);
        recyclerView.setAdapter(listPokemonAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (ableToLoad) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Chargement terminé.");

                            ableToLoad = false;
                            offset += 20;
                            obtenerData(offset);
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ableToLoad = true;
        offset = 0;
        obtenerData(offset);

    }

    private void obtenerData(final int offset) {
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonResponse> pokemonResponseCall = service.obtenerListPokemon(20, offset);

        pokemonResponseCall.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, final Response<PokemonResponse> response) {
                ableToLoad = true;
                if (response.isSuccessful()) {

                    final PokemonResponse pokemonResponse = response.body();
                    final ArrayList<Pokemon> listPokemon = pokemonResponse.getResults();

                    listPokemonAdapter.addListPokemon(listPokemon);

                } else {
                    Log.e(TAG, " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                ableToLoad = true;
                Log.e(TAG, " onFailure: " + t.getMessage());

            }
        });

    }
}
