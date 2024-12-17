package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class BaseActivity extends AppCompatActivity {

    protected MaterialButton productsButton, cartButton, signOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base); // Ensure the correct layout is set for the buttons

        // Initialize buttons with the correct IDs
        productsButton = findViewById(R.id.productsButton);
        cartButton = findViewById(R.id.cartButton);
        signOutButton = findViewById(R.id.signOutButton);

        // Check if buttons are correctly initialized
        if (productsButton == null || cartButton == null || signOutButton == null) {
            Log.e("BaseActivity", "Buttons are not properly initialized.");
        } else {
            Log.d("BaseActivity", "Buttons initialized successfully.");
        }

        // Set up button click listeners
        setupButtonListeners();
    }

    private void setupButtonListeners() {
        // Navigate to products
        productsButton.setOnClickListener(v -> {
            Log.d("BaseActivity", "Products button clicked");
            Toast.makeText(this, "Products button clicked", Toast.LENGTH_SHORT).show();
            navigateToProducts();
        });

        // Navigate to cart
        cartButton.setOnClickListener(v -> {
            Log.d("BaseActivity", "Cart button clicked");
            Toast.makeText(this, "Cart button clicked", Toast.LENGTH_SHORT).show();
            navigateToCart();
        });

        // Sign out
        signOutButton.setOnClickListener(v -> {
            Log.d("BaseActivity", "Sign Out button clicked");
            Toast.makeText(this, "Sign Out button clicked", Toast.LENGTH_SHORT).show();
            signOut();
        });
    }

    private void navigateToProducts() {
        Log.d("BaseActivity", "Navigating to Products");
        Intent intent = new Intent(BaseActivity.this, ProductListActivity.class);
        startActivity(intent);
    }

    private void navigateToCart() {
        Log.d("BaseActivity", "Navigating to Cart");
        Intent intent = new Intent(BaseActivity.this, CartActivity.class);
        startActivity(intent);
    }

    private void signOut() {
        Intent intent = new Intent(BaseActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}