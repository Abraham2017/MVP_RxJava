package com.example.udemypatterns.models;

import com.google.gson.annotations.SerializedName;


public class Pokemon {

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        String[] urlPartes = url.split("/");
        return Long.parseLong(urlPartes[urlPartes.length - 1]);
    }
}
