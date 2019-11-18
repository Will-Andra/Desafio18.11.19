package com.example.desafiomarvel.model.repository;

import com.example.desafiomarvel.model.pojos.Characters;

import io.reactivex.Observable;

import static com.example.desafiomarvel.model.data.remote.Retrofit.getApiService;

public class PersonagemRepository {

    public Observable<Characters> getPersonagemRepositori(

            String orderBy,
            String ts,
            String hash,
            String apikey){

        return getApiService().getALLPersonagens(orderBy, ts, hash, apikey);

    }

}
