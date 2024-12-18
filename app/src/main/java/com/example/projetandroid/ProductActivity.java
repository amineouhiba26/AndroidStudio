package com.example.projetandroid;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends BaseActivity {

    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private List<Product> filteredList;

    private SearchView searchView;
    private Spinner filterSpinner;

    private String currentCategory = "All";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // Initialize RecyclerView
        productRecyclerView = findViewById(R.id.productRecyclerView);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize SearchView and Spinner
        searchView = findViewById(R.id.searchView);
        filterSpinner = findViewById(R.id.filterSpinner);

        // Generate Product List
        productList = getSampleProducts();
        filteredList = new ArrayList<>(productList); // Initially display all products

        // Set up Adapter
        productAdapter = new ProductAdapter(this, filteredList);
        productRecyclerView.setAdapter(productAdapter);

        // Setup SearchView
        setupSearchView();

        // Setup Filter Spinner
        setupFilterSpinner();
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
        // Spinner Data
        String[] categories = {"All", "Electronics", "Clothing", "Books", "Home Appliances"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(spinnerAdapter);

        // Listener for Category Selection
        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                currentCategory = parent.getItemAtPosition(position).toString();
                filterProducts();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
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

    // Function to create sample product data
    private List<Product> getSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("air force 1", 119.99, R.drawable.product1_image , "shoes"));
        products.add(new Product("blanc", 139.99, R.drawable.product2_image, "shoes"));
        products.add(new Product("gris ", 150.49, R.drawable.product3_image, "shoes"));
        products.add(new Product("bleu", 59.99, R.drawable.product4_image, "shoes"));
        products.add(new Product("noir", 125.99, R.drawable.product5_image, "shoes"));
        return products;
    }
}
