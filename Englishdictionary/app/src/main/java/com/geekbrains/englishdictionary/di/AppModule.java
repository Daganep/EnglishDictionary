package com.geekbrains.englishdictionary.di;

import android.app.Application;

import com.geekbrains.englishdictionary.model.Model;
import com.geekbrains.englishdictionary.model.entity.SearchResult;
import com.geekbrains.englishdictionary.model.retrofit.RetrofitApi;
import com.geekbrains.englishdictionary.presenter.ListPresenter;
import com.geekbrains.englishdictionary.presenter.MainPresenter;
import com.geekbrains.englishdictionary.view.list.ListActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    RetrofitApi provideRetrofitApi(){return new RetrofitApi();}

    @Singleton
    @Provides
    SearchResult provideSearchResult(){return new SearchResult();}

    @Singleton
    @Provides
    MainPresenter provideMainPresenter(){return new MainPresenter();}

    @Singleton
    @Provides
    ListPresenter provideListPresenter(){return new ListPresenter();}

    @Singleton
    @Provides
    Model provideModel(){return new Model();}

    @Singleton
    @Provides
    ListActivity provideListActivity(){return new ListActivity();}
}
