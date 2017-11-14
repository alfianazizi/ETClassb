package com.example.azizi.etclass;

/**
 * Created by Azizi on 11/14/2017.
 */

public class Uploads {

    public String name;
    public String url;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Uploads() {
    }

    public Uploads(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

}
