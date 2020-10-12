package com.geekbrains.englishdictionary.model;

import com.geekbrains.englishdictionary.model.entity.SearchResult;

import java.util.List;

public class Model {
    private String currentWord = "";
    private SearchResult data1;
    private List<SearchResult> data;

    public List<SearchResult> getData() {
        return data;
    }

    public void setData(List<SearchResult> data) {
        this.data = data;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public SearchResult getData1() {
        return data1;
    }

    public void setData1(SearchResult data1) {
        this.data1 = data1;
    }
}
