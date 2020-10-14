package com.geekbrains.englishdictionary.view.list;

import com.geekbrains.englishdictionary.model.entity.SearchResult;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.SkipStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface ListView extends MvpView {
    @StateStrategyType(value = SkipStrategy.class)
    void updateRecyclerView(List<SearchResult> data);
}
