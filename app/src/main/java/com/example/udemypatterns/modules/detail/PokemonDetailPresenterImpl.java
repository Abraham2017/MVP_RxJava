package com.example.udemypatterns.modules.detail;

import com.example.udemypatterns.implementations.PokemonInteractorOnlineImpl;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PokemonDetailPresenterImpl implements PokemonDetailPresenter {

    private PokemonDetailView mView;
    private CompositeDisposable compositeDisposable;
    private PokemonInteractorOnlineImpl pokemonInteractor;

    public PokemonDetailPresenterImpl(PokemonDetailView mView) {
        this.mView = mView;
        compositeDisposable = new CompositeDisposable();
        pokemonInteractor = new PokemonInteractorOnlineImpl();
    }

    @Override
    public void getPokemon(long id) {
        get(id);
    }

    private void get(long id) {
        compositeDisposable
                .add(pokemonInteractor.
                        getPokemonById(id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(mView::getPokemon
                                , mView::onError));
    }
}
