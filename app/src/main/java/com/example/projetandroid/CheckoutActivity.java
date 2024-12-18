package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    private RadioGroup deliveryOptionGroup;
    private RadioButton deliveryRadioButton, pickupRadioButton;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        deliveryOptionGroup = findViewById(R.id.deliveryOptionGroup);
        deliveryRadioButton = findViewById(R.id.deliveryRadioButton);
        pickupRadioButton = findViewById(R.id.pickupRadioButton);
        checkoutButton = findViewById(R.id.checkoutButton);

        checkoutButton.setOnClickListener(v -> {
            int selectedOption = deliveryOptionGroup.getCheckedRadioButtonId();

            if (selectedOption == -1) {
                Toast.makeText(CheckoutActivity.this, "Please choose delivery or pick-up", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(CheckoutActivity.this, ThankYouActivity.class);
                startActivity(intent);
            }
        });
    }
}
