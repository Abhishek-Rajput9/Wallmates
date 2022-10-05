package com.example.wallmates.Modals;

public class categoryModal {
    private  String name , image, type;

    public categoryModal() {
    }

    public categoryModal(String name, String image, String type) {
        this.name = name;
        this.image = image;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
