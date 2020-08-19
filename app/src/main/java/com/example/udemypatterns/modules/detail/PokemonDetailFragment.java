package com.example.udemypatterns.modules.detail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.udemypatterns.R;
import com.example.udemypatterns.databinding.PokemonDetailLayoutBinding;
import com.example.udemypatterns.interfaces.OnPokemonClickListener;
import com.example.udemypatterns.models.PokemonDetail;

public class PokemonDetailFragment extends Fragment implements PokemonDetailView {

    private PokemonDetailLayoutBinding binding;
    private PokemonDetailPresenter presenter;
    private OnPokemonClickListener listener;

    public static PokemonDetailFragment newInstance(Bundle args) {
        PokemonDetailFragment fragment = new PokemonDetailFragment();
        if (args != null) {
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnPokemonClickListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.pokemon_detail_layout, container, false);
        presenter = new PokemonDetailPresenterImpl(this);
        if (getArguments() != null) {
            presenter.getPokemon(getArguments().getLong("id"));
        }
        return binding.getRoot();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(getContext(), "Error al obtener la info" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getPokemon(PokemonDetail pokemon) {
        binding.setPokemon(pokemon);
        listener.changeText(pokemon.getName());
    }

    @Override
    public void onDestroyView() {
        listener.changeText("Pokedex Rx");
        super.onDestroyView();
    }
}
