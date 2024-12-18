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

        Button startShoppingButton = findViewById(R.id.startShoppingButton);
        signOutButton = findViewById(R.id.signOutButton);
        viewCartButton = findViewById(R.id.viewCartButton);

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        viewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewCart();
            }
        });

        startShoppingButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProductActivity.class);
            startActivity(intent);
        });


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    private void signOut() {

        Toast.makeText(MainActivity.this, "Signed Out", Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(MainActivity.this, LoginActivity.class);  // Replace with your actual login activity
        startActivity(intent);
        finish();
    }

    private void viewCart() {
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        startActivity(intent);
    }
}
