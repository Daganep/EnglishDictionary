package com.geekbrains.englishdictionary.view.list;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.geekbrains.englishdictionary.R;
import com.geekbrains.englishdictionary.databinding.ActivityListBinding;
import com.geekbrains.englishdictionary.di.App;
import com.geekbrains.englishdictionary.presenter.ListPresenter;
import com.geekbrains.englishdictionary.view.recyclerview.RecyclerViewAdapter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class ListActivity extends MvpAppCompatActivity implements ListView {

    @InjectPresenter
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
        listActivityBinding.recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(listActivityBinding.recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        listActivityBinding.recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void updateRecyclerView(){
        initRecycler();
        adapter.notifyDataSetChanged();
        listActivityBinding.progressBar.setVisibility(View.GONE);
        listActivityBinding.recyclerView.setVisibility(View.VISIBLE);
    }
}