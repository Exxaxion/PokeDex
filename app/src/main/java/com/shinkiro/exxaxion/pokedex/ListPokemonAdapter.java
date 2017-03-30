package com.shinkiro.exxaxion.pokedex;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.shinkiro.exxaxion.pokedex.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Exxaxion on 24/03/2017.
 */

public class ListPokemonAdapter extends RecyclerView.Adapter<ListPokemonAdapter.ViewHolder> {


    public static ArrayList<Pokemon> dataset;
    private Context context;

    public ListPokemonAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Pokemon p = dataset.get(position);
        holder.pokemonTextView.setText(p.getName());

        Glide.with(context)
                .load(p.getImageUrl())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.pictureImageView);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = PokemonStatsActivity.newIntent(context, dataset.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addListPokemon(List<Pokemon> listPokemon) {
        dataset.addAll(listPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View parent;
        private ImageView pictureImageView;
        private TextView pokemonTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            parent = itemView;
            pictureImageView = (ImageView) itemView.findViewById(R.id.imgPokemon);
            pokemonTextView = (TextView) itemView.findViewById(R.id.namePokemon);

        }
    }
}
