package com.geekbrains.englishdictionary.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Translation {
    @Expose
    @SerializedName("text")
    private String translation;

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
