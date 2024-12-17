package com.example.projetandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.projetandroid.Product; // Ensure this is imported

public class ProductListActivity extends BaseActivity  {

    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // Initialize RecyclerView
        productRecyclerView = findViewById(R.id.productRecyclerView);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of your Product objects
        List<Product> productList = getSampleProducts();

        // Set up the adapter with your Product class
        productAdapter = new ProductAdapter(this, productList);
        productRecyclerView.setAdapter(productAdapter);


    }

    // Function to create sample product data
    private List<Product> getSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 10.99, R.drawable.product1_image));
        products.add(new Product("Product 2", 19.99, R.drawable.product2_image));
        return products;
    }
}
