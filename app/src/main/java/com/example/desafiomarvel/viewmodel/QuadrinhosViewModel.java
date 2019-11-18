package com.example.desafiomarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.desafiomarvel.model.pojos.Characters;
import com.example.desafiomarvel.model.pojos.Quadrinhos;
import com.example.desafiomarvel.model.pojos.Result;
import com.example.desafiomarvel.model.repository.ComicsRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.desafiomarvel.util.AppUtils.md5;

public class QuadrinhosViewModel extends AndroidViewModel {


    private MutableLiveData<List<Result>> listaComics = new MutableLiveData<>();
    private ComicsRepository comicsRepository = new ComicsRepository();
    private CompositeDisposable disposable = new CompositeDisposable();

    public static final String PUBLIC_KEY = "fe81c0a4bd6c7f00e3df25d68d8d8a92";

    public static final String PRIVATE_KEY = "ceac13aef2089eaf3c704ba9da60cf2156b60912";

    String ts = Long.toString(System.currentTimeMillis() / 1000);

    String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);

    public QuadrinhosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getListaComics(){
        return this.listaComics;
    }

    public void getComics() {

        disposable.add(
                comicsRepository.getComicsRepository("magazine", "comic", true, "title", ts, hash, PUBLIC_KEY)

                        .subscribeOn(Schedulers.newThread())

                        .observeOn(AndroidSchedulers.mainThread())

                        .subscribe(new Consumer<Quadrinhos>() {
                            @Override
                            public void accept(Quadrinhos response) throws Exception {

                                listaComics.setValue(response.getData().getResults());
                            }
                        }, throwable -> {

                            Log.i("LOG", "Error: " + throwable.getMessage());
                        }));
    }
}





