package com.example.udemypatterns.models;

import com.google.gson.annotations.SerializedName;

public class Tipo {

    @SerializedName("type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
