package com.geekbrains.englishdictionary.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meanings {
    @Expose
    @SerializedName("translation")
    private Translation translation;

    @Expose
    @SerializedName("imageUrl")
    private String imageUrl;

    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
