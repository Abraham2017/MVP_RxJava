package com.example.udemypatterns.api;

import com.example.udemypatterns.models.PokemonDetail;
import com.example.udemypatterns.models.PokemonList;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonAPI {

    @GET("pokemon")
    Single<PokemonList> getPokemon(@Query("limit") int limit, @Query("offset") int offset);


    @GET("pokemon/{id}")
    Single<PokemonDetail> getPokemonById(@Path("id") long id);
}
