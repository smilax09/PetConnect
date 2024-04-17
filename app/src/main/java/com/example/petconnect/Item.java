package com.example.petconnect;

public class Item {
    private int imageResource;  // Resource ID for the product image
    private String name;        // Name of the product
    private int price;       // Price of the product

    public Item(int imageResource, String name, int price) {
        this.imageResource = imageResource;
        this.name = name;
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
