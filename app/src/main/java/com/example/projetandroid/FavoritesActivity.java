package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView favoritesRecyclerView;
    private FavoriteAdapter favoriteAdapter;
    private MaterialButton homeButton, productListButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        favoritesRecyclerView = findViewById(R.id.favoritesRecyclerView);
        homeButton = findViewById(R.id.homeButton);
        productListButton = findViewById(R.id.productListButton);
        MaterialButton viewCartButton = findViewById(R.id.viewCartButton);


        List<Product> favoriteProducts = loadFavoriteProducts();

        favoriteAdapter = new FavoriteAdapter(favoriteProducts);
        favoritesRecyclerView.setAdapter(favoriteAdapter);

        // Navigate to Home
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(FavoritesActivity.this, MainActivity.class);
            startActivity(intent);
        });

        productListButton.setOnClickListener(v -> {
            Intent intent = new Intent(FavoritesActivity.this, ProductActivity.class);
            startActivity(intent);
        });
        viewCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(FavoritesActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }

    /**
     * Method to load favorite products.
     * This is a stubbed method. Replace this with actual logic for loading data
     * from a database, SharedPreferences, or any other persistent storage.
     */
    private List<Product> loadFavoriteProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Noir", 125.99, R.drawable.s1, "survetements"));


        return products;
    }
}
