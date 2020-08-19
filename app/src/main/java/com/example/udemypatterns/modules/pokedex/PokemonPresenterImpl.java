package com.example.udemypatterns.modules.pokedex;
import com.example.udemypatterns.implementations.PokemonInteractorOnlineImpl;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PokemonPresenterImpl implements PokemonPresenter {

    private PokemonView mView;
    private CompositeDisposable compositeDisposable;
    private PokemonInteractorOnlineImpl pokemonInteractor;

    public PokemonPresenterImpl(PokemonView mView) {
        this.mView = mView;
        compositeDisposable = new CompositeDisposable();
        pokemonInteractor = new PokemonInteractorOnlineImpl();
    }

    @Override
    public void onNext(int next) {
        getPokemonList(next);
    }

    @Override
    public void onBack(int back) {
        getPokemonList(back);
    }

    private void getPokemonList(int offset) {
        compositeDisposable.add(pokemonInteractor.getPokemon(20, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mView::getPokemones,
                        mView::onError));
    }
}
