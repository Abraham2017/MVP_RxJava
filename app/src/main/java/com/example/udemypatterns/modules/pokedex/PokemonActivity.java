package com.example.udemypatterns.modules.pokedex;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.udemypatterns.interfaces.OnPokemonClickListener;
import com.example.udemypatterns.models.PokemonList;
import com.example.udemypatterns.modules.detail.PokemonDetailFragment;
import com.example.udemypatterns.R;
import com.example.udemypatterns.adapters.PokemonAdapter;
import com.example.udemypatterns.databinding.ActivityExampleBinding;

public class PokemonActivity extends AppCompatActivity implements PokemonView, OnPokemonClickListener {

    private ActivityExampleBinding binding;
    private PokemonAdapter adapter;
    private int offset = 0;
    private PokemonPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_example);
        setSupportActionBar(binding.toolbar);
        this.getSupportActionBar().setTitle("");
        binding.toolbarTitle.setText("Pokedex Rx");
        binding.setContext(this);
        presenter = new PokemonPresenterImpl(this);
        presenter.onBack(offset);
        binding.btnAnterior.setOnClickListener(view -> {
            if (offset != 0){
                offset -= 20;
            }
            presenter.onBack(offset);
        });
        binding.btnSiguiente.setOnClickListener(view -> {
            offset += 20;
            presenter.onNext(offset);
        });
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(this, "Error al obtener la info" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getPokemones(PokemonList pokemonList) {
        adapter = new PokemonAdapter(pokemonList.getPokemonList(),this);
        binding.rvPokemon.setLayoutManager(new GridLayoutManager(binding.getContext(), 3));
        binding.rvPokemon.setHasFixedSize(true);
        binding.setPokemonAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void sendPokemonNumber(long id) {
        Bundle args = new Bundle();
        args.putLong("id",id);
        addFragment(PokemonDetailFragment.newInstance(args));
    }

    @Override
    public void changeText(String pokemon) {
        binding.toolbarTitle.setText(pokemon);
    }

    private void addFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.detail_container,fragment);
        transaction.addToBackStack("detail_pokemon");
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }
    }
}