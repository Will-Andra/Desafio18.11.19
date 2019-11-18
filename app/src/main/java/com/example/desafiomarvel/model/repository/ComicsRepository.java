package com.example.desafiomarvel.model.repository;

import com.example.desafiomarvel.model.pojos.Quadrinhos;

import io.reactivex.Observable;

import static com.example.desafiomarvel.model.data.remote.Retrofit.getApiService;

public class ComicsRepository {

    public Observable<Quadrinhos> getComicsRepository(String format,
                                                      String formatType,
                                                      Boolean noVariants,
                                                      String orderBy,
                                                      String ts,
                                                      String hash,
                                                      String apikey) {
        return getApiService().getAllQuadrinhos(format, formatType, noVariants, orderBy, ts, hash, apikey);
    }
}

