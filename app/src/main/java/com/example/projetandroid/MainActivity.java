package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private Button signOutButton;
    private Button viewCartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Start Shopping button
        Button startShoppingButton = findViewById(R.id.startShoppingButton);
        signOutButton = findViewById(R.id.signOutButton);
        viewCartButton = findViewById(R.id.viewCartButton);

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        // Handle View Cart Button click
        viewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewCart();
            }
        });

        // Set click listener to navigate to ProductActivity
        startShoppingButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProductActivity.class);
            startActivity(intent);
        });


        // Make sure the action bar is set correctly
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    private void signOut() {
        // Clear user session data or perform any necessary actions for logging out
        // For example, if you were using SharedPreferences, you would clear them:
        // SharedPreferences sharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE);
        // sharedPreferences.edit().clear().apply();

        // Show a message
        Toast.makeText(MainActivity.this, "Signed Out", Toast.LENGTH_SHORT).show();

        // Redirect to the login screen or home screen
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);  // Replace with your actual login activity
        startActivity(intent);
        finish(); // Optional: Close the current activity (MainActivity) to prevent users from navigating back to it
    }

    // Method to handle viewing the cart
    private void viewCart() {
        // Navigate to CartActivity to show the user's cart
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        startActivity(intent);
    }
}
