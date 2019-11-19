package com.e.marvelapp.repository;

import com.e.marvelapp.model.ComicsResponse;

import io.reactivex.Observable;

import static com.e.marvelapp.data.remote.RetrofitService.getApiService;

public class ComicsRepository {
    public Observable<ComicsResponse> getComicsRepository(String format,
                                                          String formatType,
                                                          Boolean noVariants,
                                                          String orderBy,
                                                          String ts,
                                                          String hash,
                                                          String apikey) {
        return getApiService().getAllComicsResponse(
                format,
                formatType,
                noVariants,
                orderBy,
                ts,
                hash,
                apikey);
    }
}
