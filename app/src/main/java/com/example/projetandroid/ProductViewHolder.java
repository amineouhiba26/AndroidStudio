package com.example.projetandroid;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    TextView productName, productPrice;
    ImageView productImage;
    Button addToCartButton;

    public ProductViewHolder(View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.productName);
        productPrice = itemView.findViewById(R.id.productPrice);
        productImage = itemView.findViewById(R.id.productImage);
        addToCartButton = itemView.findViewById(R.id.addToCartButton);
    }
}
