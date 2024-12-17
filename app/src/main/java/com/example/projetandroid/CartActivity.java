package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartActivity extends BaseActivity {

    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private List<Product> cartList;
    private TextView totalPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize views
        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        totalPriceTextView = findViewById(R.id.totalPriceTextView);
        Button checkoutButton = findViewById(R.id.checkoutButton);
        Button homeButton = findViewById(R.id.homeButton); // Home Button
        Button productListButton = findViewById(R.id.productListButton); // Product List Button

        // Get the cart products from CartManager
        cartList = CartManager.getInstance().getCart();

        // Set up RecyclerView with CartAdapter
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(this, cartList);
        cartRecyclerView.setAdapter(cartAdapter);

        // Calculate and display the total price
        updateTotalPrice();

        // Handle checkout button click
        checkoutButton.setOnClickListener(v -> {
            if (cartList.isEmpty()) {
                Toast.makeText(this, "Your cart is empty!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(intent);  // Navigate to CheckoutActivity
            }
        });

        // Handle Home button click
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, MainActivity.class); // Navigate to Home Activity
            startActivity(intent);
        });

        // Handle Product List button click
        productListButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, ProductActivity.class); // Navigate to Product List Activity
            startActivity(intent);
        });
    }

    private void updateTotalPrice() {
        double totalPrice = 0;
        for (Product product : cartList) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        totalPriceTextView.setText(String.format("Total: $%.2f", totalPrice));  // Display total price
    }
}
