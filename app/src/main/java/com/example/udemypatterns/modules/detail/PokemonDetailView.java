package com.example.udemypatterns.modules.detail;

import com.example.udemypatterns.models.PokemonDetail;

public interface PokemonDetailView {

    void onSuccess();
    void onError(Throwable throwable);
    void getPokemon(PokemonDetail pokemon);

}
