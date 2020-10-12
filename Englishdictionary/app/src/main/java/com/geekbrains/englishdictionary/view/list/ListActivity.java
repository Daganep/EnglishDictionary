package com.geekbrains.englishdictionary.view.list;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.geekbrains.englishdictionary.R;
import com.geekbrains.englishdictionary.databinding.ActivityListBinding;
import com.geekbrains.englishdictionary.di.App;
import com.geekbrains.englishdictionary.model.Model;
import com.geekbrains.englishdictionary.model.entity.SearchResult;
import com.geekbrains.englishdictionary.presenter.ListPresenter;
import com.geekbrains.englishdictionary.presenter.MainPresenter;
import com.geekbrains.englishdictionary.view.recyclerview.RecyclerViewAdapter;

import javax.inject.Inject;

import moxy.MvpAppCompatActivity;

public class ListActivity extends MvpAppCompatActivity implements ListView {

    @Inject
    ListPresenter listPresenter;

    public ListActivity(){
        App.getAppComponent().inject(this);
    }

    private ActivityListBinding listActivityBinding;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listActivityBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_list);

        listPresenter.requestFromServer();
    }

    private void initRecycler(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        listActivityBinding.recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerViewAdapter(listPresenter.getData());
        Log.d("kek", "data is " + listPresenter.getData());
        listActivityBinding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateRecyclerView(){
        Log.d("kek", "now in update");
        initRecycler();
        adapter.notifyDataSetChanged();
    }
}