package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends BaseActivity {

    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private Button viewCartButton;
    private SearchView searchView;  // Declare SearchView from androidx.appcompat.widget

    private List<Product> productList;
    private List<Product> filteredProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // Initialize Views
        Button homeButton = findViewById(R.id.homeButton);
        searchView = findViewById(R.id.searchView);  // Initialize SearchView from androidx.appcompat.widget
        productRecyclerView = findViewById(R.id.productRecyclerView);
        viewCartButton = findViewById(R.id.viewCartButton);

        // Initialize RecyclerView
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load products and set up the adapter
        productList = getSampleProducts();
        filteredProductList = new ArrayList<>(productList); // Copy of the full list
        productAdapter = new ProductAdapter(this, filteredProductList);
        productRecyclerView.setAdapter(productAdapter);

        // Set up View Cart Button
        viewCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProductActivity.this, CartActivity.class);
            startActivity(intent);
        });

        // Set up Home Button
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProductActivity.this, MainActivity.class); // Navigate to Home Activity
            startActivity(intent);
        });

        // Set up SearchView to filter product list by name
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false; // We don't need to handle query submission
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter products based on the entered text
                filterProducts(newText);
                return true;
            }
        });
    }

    // Create a sample product list
    private List<Product> getSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("air force 1", 119.99, R.drawable.product1_image));
        products.add(new Product("blanc", 139.99, R.drawable.product2_image));
        products.add(new Product("gris ", 150.49, R.drawable.product3_image));
        products.add(new Product("bleu", 59.99, R.drawable.product4_image));
        products.add(new Product("noir", 125.99, R.drawable.product5_image));

        return products;
    }

    // Filter products based on search query
    private void filterProducts(String query) {
        filteredProductList.clear();
        if (query.isEmpty()) {
            filteredProductList.addAll(productList);
        } else {
            for (Product product : productList) {
                if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredProductList.add(product);
                }
            }
        }
        productAdapter.notifyDataSetChanged(); // Update the adapter with the filtered list
    }
}
