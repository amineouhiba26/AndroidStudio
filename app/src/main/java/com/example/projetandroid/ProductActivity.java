package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.appcompat.widget.SearchView; // Use androidx.appcompat.widget.SearchView
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends BaseActivity {

    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private List<Product> filteredList;

    private SearchView searchView;
    private Spinner filterSpinner;
    private TextView productListTitle;

    private String currentCategory = "All";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productRecyclerView = findViewById(R.id.productRecyclerView);
        searchView = findViewById(R.id.searchView);
        filterSpinner = findViewById(R.id.filterSpinner);
        productListTitle = findViewById(R.id.productListTitle);

        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = getSampleProducts();
        filteredList = new ArrayList<>(productList);

        productAdapter = new ProductAdapter(this, filteredList);
        productRecyclerView.setAdapter(productAdapter);

        setupSearchView();

        setupFilterSpinner();

        setupButtonActions();
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterProducts();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterProducts();
                return true;
            }
        });
    }

    private void setupFilterSpinner() {
        String[] categories = {"All", "shoes", "survetements", "jeans", "casquettes", "crampons"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(spinnerAdapter);

        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                currentCategory = parent.getItemAtPosition(position).toString();
                filterProducts();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void filterProducts() {
        String query = searchView.getQuery().toString().toLowerCase();
        filteredList.clear();

        for (Product product : productList) {
            boolean matchesCategory = currentCategory.equals("All") || product.getCategory().equals(currentCategory);
            boolean matchesSearch = TextUtils.isEmpty(query) || product.getName().toLowerCase().contains(query);

            if (matchesCategory && matchesSearch) {
                filteredList.add(product);
            }
        }

        productAdapter.notifyDataSetChanged();
    }

    private List<Product> getSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Air Force 1", 119.99, R.drawable.product1_image, "shoes"));
        products.add(new Product("Blanc", 139.99, R.drawable.product2_image, "shoes"));
        products.add(new Product("Gris", 150.49, R.drawable.product3_image, "shoes"));
        products.add(new Product("Bleu", 59.99, R.drawable.product4_image, "shoes"));
        products.add(new Product("Noir", 125.99, R.drawable.product5_image, "shoes"));

        products.add(new Product("casquette beige", 125.99, R.drawable.c1, "casquettes"));
        products.add(new Product("casquette noire", 125.99, R.drawable.c2, "casquettes"));
        products.add(new Product("casquette gris", 125.99, R.drawable.c3, "casquettes"));
        products.add(new Product("casquette bleue", 125.99, R.drawable.c5, "casquettes"));

        products.add(new Product("crampon orange", 125.99, R.drawable.r1, "crampons"));
        products.add(new Product("crampon bleu", 125.99, R.drawable.r2, "crampons"));
        products.add(new Product("crampon jaune", 125.99, R.drawable.r3, "crampons"));
        products.add(new Product("crampon vert", 125.99, R.drawable.r4, "crampons"));
        products.add(new Product("crampon marron", 125.99, R.drawable.r5, "crampons"));

        products.add(new Product("jeans", 125.99, R.drawable.j1, "jeans"));
        products.add(new Product("jeans", 125.99, R.drawable.j2, "jeans"));
        products.add(new Product("jeans", 125.99, R.drawable.j3, "jeans"));
        products.add(new Product("jeans", 125.99, R.drawable.j4, "jeans"));
        products.add(new Product("jeans", 125.99, R.drawable.j5, "jeans"));

        products.add(new Product("Noir", 125.99, R.drawable.s1, "survetements"));
        products.add(new Product("Noir", 125.99, R.drawable.s2, "survetements"));
        products.add(new Product("Noir", 125.99, R.drawable.s3, "survetements"));
        products.add(new Product("Noir", 125.99, R.drawable.s4, "survetements"));
        products.add(new Product("Noir", 125.99, R.drawable.s5, "survetements"));

        return products;
    }

    private void setupButtonActions() {
        MaterialButton viewCartButton = findViewById(R.id.viewCartButton);
        MaterialButton viewFavoritesButton = findViewById(R.id.viewFavoritesButton);
        MaterialButton homeButton = findViewById(R.id.homeButton);

        viewCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProductActivity.this, CartActivity.class);
            startActivity(intent);
        });

        viewFavoritesButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProductActivity.this, FavoritesActivity.class);
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProductActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
