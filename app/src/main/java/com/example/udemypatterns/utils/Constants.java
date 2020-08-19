package com.example.udemypatterns.utils;

public class Constants {

    public static String BASE_URL = "https://pokeapi.co/api/v2/";

    public static String URL_IMAGE = "";

    public static final String DATABASE_NAME = "pokeDB";

    public static final String TABLE_NAME = "pokemon";

    public static final String COLUMN_NAME = "name";

    public static final String COLUMN_URL = "url";

    public static String getImageUrl(Long id) {
        return String.format("%s%s%s", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/",id,".png");
    }

}
