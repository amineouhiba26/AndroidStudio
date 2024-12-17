// Product.java
package com.example.projetandroid;

public class Product {
    private String name;
    private double price;
    private int imageResourceId;
    private int quantity; // Quantity of product

    public Product(String name, double price, int imageResourceId) {
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.quantity = 1; // Default quantity is 1
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
