package com.example.projetandroid;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static List<Product> cartItems = new ArrayList<>();

    public static void addToCart(Product product) {
        cartItems.add(product);
    }

    public static List<Product> getCartItems() {
        return cartItems;
    }

    public static double getTotalPrice() {
        double total = 0.0;
        for (Product product : cartItems) {
            total += product.getPrice();
        }
        return total;
    }
}
