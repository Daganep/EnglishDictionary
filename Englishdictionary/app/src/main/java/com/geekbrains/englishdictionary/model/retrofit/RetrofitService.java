package com.geekbrains.englishdictionary.model.retrofit;

import com.geekbrains.englishdictionary.model.entity.SearchResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("words/search")
    Observable<List<SearchResult>> getData(@Query("search") String search);

    /*@GET("words/search?search=country")
    Observable<List<SearchResult>> getData();*/
}