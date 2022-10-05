package com.example.wallmates.Modals;

import java.io.Serializable;

public class bomModal implements Serializable {
    private String image, type ;

    public bomModal() {
    }

    public bomModal(String image, String type) {
        this.image = image;
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
