package com.geekbrains.englishdictionary.presenter;

import android.util.Log;

import com.geekbrains.englishdictionary.di.App;
import com.geekbrains.englishdictionary.model.Model;
import com.geekbrains.englishdictionary.model.entity.SearchResult;
import com.geekbrains.englishdictionary.model.retrofit.RetrofitApi;
import com.geekbrains.englishdictionary.view.list.ListView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class ListPresenter extends MvpPresenter<ListView> {

    @Inject
    RetrofitApi retrofitApi;

    @Inject
    Model model;

    private Disposable disposable;

    public ListPresenter(){
        App.getAppComponent().inject(this);
    }

    public void requestFromServer(){
        Observable<List<SearchResult>> single = retrofitApi.requestServer();

        disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(emitter -> {
            getViewState().updateRecyclerView(emitter);
            }, throwable -> {
            Log.e("Error", "onError" + throwable);
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public String getWord(){
        return model.getCurrentWord();
    }
}
