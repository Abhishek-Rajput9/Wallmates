package com.example.wallmates.Modals;

import java.io.Serializable;

public class newestModal implements Serializable{
    private String image, type, color;

    public newestModal() {
    }

    public newestModal(String image, String type, String color) {
        this.image = image;
        this.type = type;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
