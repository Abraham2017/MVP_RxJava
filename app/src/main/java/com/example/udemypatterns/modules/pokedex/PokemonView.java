package com.example.udemypatterns.modules.pokedex;

import com.example.udemypatterns.models.PokemonList;

public interface PokemonView {
    void onSuccess();
    void onError(Throwable throwable);
    void getPokemones(PokemonList pokemonList);
}
