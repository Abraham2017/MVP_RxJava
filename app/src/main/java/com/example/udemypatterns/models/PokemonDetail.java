package com.example.udemypatterns.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonDetail {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("height")
    private Integer height;

    @SerializedName("weigth")
    private Integer weight;

    @SerializedName("types")
    private List<Type> tipos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Type> getTipos() {
        return tipos;
    }

    public void setTipos(List<Type> tipos) {
        this.tipos = tipos;
    }
}
