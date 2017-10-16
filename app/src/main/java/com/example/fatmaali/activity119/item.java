package com.example.fatmaali.activity119;

/**
 * Created by Fatma Ali on 15/09/2017.
 */

public class item {
    private String name;
    private int image_id;

    public item(String name, int image_id) {
        this.name = name;
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
