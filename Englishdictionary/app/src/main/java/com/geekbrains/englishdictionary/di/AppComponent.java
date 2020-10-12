package com.geekbrains.englishdictionary.di;

import com.geekbrains.englishdictionary.model.Model;
import com.geekbrains.englishdictionary.model.entity.SearchResult;
import com.geekbrains.englishdictionary.model.retrofit.RetrofitApi;
import com.geekbrains.englishdictionary.presenter.ListPresenter;
import com.geekbrains.englishdictionary.presenter.MainPresenter;
import com.geekbrains.englishdictionary.view.list.ListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(RetrofitApi retrofitApi);

    void inject(SearchResult searchResult);

    void inject(MainPresenter mainPresenter);

    void inject(ListPresenter listPresenter);

    void inject(Model model);

    void inject(ListActivity listActivity);
}
