package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ThankYouActivity extends AppCompatActivity {

    private Button backToHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        // Initialize button
        backToHomeButton = findViewById(R.id.backToHomeButton);

        // Set click listener to navigate back to the main activity or home screen
        backToHomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(ThankYouActivity.this, MainActivity.class); // Assuming MainActivity is your home activity
            startActivity(intent);
            finish();
        });
    }
}
