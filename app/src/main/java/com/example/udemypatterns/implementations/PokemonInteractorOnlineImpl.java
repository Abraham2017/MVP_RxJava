package com.example.udemypatterns.implementations;

import com.example.udemypatterns.api.PokemonAPI;
import com.example.udemypatterns.models.PokemonDetail;
import com.example.udemypatterns.models.PokemonList;
import com.example.udemypatterns.utils.RetrofitClient;

import io.reactivex.rxjava3.core.Single;

public class PokemonInteractorOnlineImpl implements PokemonAPI {

    private PokemonAPI api;

    public PokemonInteractorOnlineImpl(){
        api = RetrofitClient.getInstance().create(PokemonAPI.class);
    }

    @Override
    public Single<PokemonList> getPokemon(int limit, int offset) {
        return api.getPokemon(limit,offset);
    }

    @Override
    public Single<PokemonDetail> getPokemonById(long id) {
        return api.getPokemonById(id);
    }
}
