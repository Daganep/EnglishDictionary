package com.geekbrains.englishdictionary.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResult {

    @Expose
    @SerializedName("text")
    private String text;

    @Expose
    @SerializedName("meanings")
    private List<Meanings> meanings;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Meanings> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meanings> meanings) {
        this.meanings = meanings;
    }
}
