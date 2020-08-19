package com.example.udemypatterns.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.udemypatterns.interfaces.OnPokemonClickListener;
import com.example.udemypatterns.databinding.PokemonItemBinding;
import com.example.udemypatterns.models.Pokemon;
import com.example.udemypatterns.utils.Constants;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {

    private List<Pokemon> pokemonList;
    private PokemonItemBinding binding;
    private OnPokemonClickListener listener;

    public PokemonAdapter(List<Pokemon> pokemonList, OnPokemonClickListener listener) {
        this.pokemonList = pokemonList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PokemonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = PokemonItemBinding.inflate(inflater, parent, false);
        return new PokemonHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonHolder holder, int position) {
        holder.setData(pokemonList.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    class PokemonHolder extends RecyclerView.ViewHolder {

        private PokemonItemBinding binding;

        public PokemonHolder(@NonNull PokemonItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(view -> {
                listener.sendPokemonNumber(pokemonList.get(getAdapterPosition()).getNumber());
            });
        }

        private void setData(Pokemon pokemon) {
            binding.setPokemon(pokemon);
            Glide.with(binding.getRoot().getContext())
                    .load(Constants.getImageUrl(pokemon.getNumber()))
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.imgPokemon);
        }
    }
}
