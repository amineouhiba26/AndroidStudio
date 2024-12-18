package com.example.projetandroid;

import java.util.ArrayList;
import java.util.List;

public class FavoriteManager {

    private static FavoriteManager instance;
    private List<Product> favoriteProducts;

    private FavoriteManager() {
        favoriteProducts = new ArrayList<>();
    }

    public static FavoriteManager getInstance() {
        if (instance == null) {
            instance = new FavoriteManager();
        }
        return instance;
    }

    public void addToFavorites(Product product) {
        if (!favoriteProducts.contains(product)) {
            favoriteProducts.add(product);
        }
    }

    public List<Product> getFavorites() {
        return favoriteProducts;
    }

    public void removeFromFavorites(Product product) {
        favoriteProducts.remove(product);
    }
}
