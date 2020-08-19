package com.example.udemypatterns.models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PokemonList {

    @SerializedName("results")
    private List<Pokemon> pokemonList;

    public List<Pokemon> getPokemonList() {
        if (pokemonList == null){
            pokemonList = new ArrayList<>();
        }
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
