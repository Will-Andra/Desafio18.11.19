package com.e.marvelapp.data.remote;

import com.e.marvelapp.model.ComicsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ComicsResponseAPI {

    @GET("comics?")
    Observable<ComicsResponse> getAllComicsResponse(
            @Query("format") String format,
            @Query("formatType") String formatType,
            @Query("noVariants") boolean noVariants,
            @Query("orderBy") String orderBy,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey
    );

}