package com.geekbrains.englishdictionary.presenter;

import com.geekbrains.englishdictionary.di.App;
import com.geekbrains.englishdictionary.model.Model;
import com.geekbrains.englishdictionary.model.entity.SearchResult;
import com.geekbrains.englishdictionary.model.retrofit.RetrofitApi;
import com.geekbrains.englishdictionary.view.main.MainView;

import java.util.List;

import javax.inject.Inject;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    RetrofitApi retrofitApi;

    @Inject
    Model model;

    List<SearchResult> data;

    public MainPresenter(){
        App.getAppComponent().inject(this);
    }

    public void setCurrentWord(String word){
        model.setCurrentWord(word);
        getViewState().showResult();
    }

}
