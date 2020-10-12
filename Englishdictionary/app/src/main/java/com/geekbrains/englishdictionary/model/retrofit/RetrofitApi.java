package com.geekbrains.englishdictionary.model.retrofit;

import android.util.Log;

import com.geekbrains.englishdictionary.di.App;
import com.geekbrains.englishdictionary.model.Model;
import com.geekbrains.englishdictionary.model.entity.SearchResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

    @Inject
    Model model;

    public RetrofitApi(){
        App.getAppComponent().inject(this);
    }

    public Observable<List<SearchResult>> requestServer(){
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        RetrofitService api = new Retrofit.Builder()
                .baseUrl("https://dictionary.skyeng.ru/api/public/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(RetrofitService.class);

        //return api.getData().subscribeOn(Schedulers.io());
        return api.getData(model.getCurrentWord()).subscribeOn(Schedulers.io()); //
    }
}
