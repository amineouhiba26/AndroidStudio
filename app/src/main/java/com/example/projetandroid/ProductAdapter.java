package com.example.projetandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;
    private Context context;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.productName.setText(product.getName());
        holder.productPrice.setText(String.format("$%.2f", product.getPrice()));
        holder.productImage.setImageResource(product.getImageResourceId());

        Integer[] quantities = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, quantities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.quantitySpinner.setAdapter(adapter);

        holder.addToCartButton.setOnClickListener(v -> {
            int quantity = (int) holder.quantitySpinner.getSelectedItem();
            product.setQuantity(quantity);
            CartManager.getInstance().addToCart(product);
            Toast.makeText(context, product.getName() + " (" + quantity + "x) added to cart", Toast.LENGTH_SHORT).show();
        });

        holder.addToFavoritesButton.setOnClickListener(v -> {
            FavoriteManager.getInstance().addToFavorites(product); // Add product to favorites
            Toast.makeText(context, product.getName() + " added to favorites", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void updateProductList(List<Product> newProductList) {
        this.productList = newProductList;
        notifyDataSetChanged();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView productName, productPrice;
        ImageView productImage;
        Spinner quantitySpinner;
        Button addToCartButton, addToFavoritesButton;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productImage = itemView.findViewById(R.id.productImage);
            quantitySpinner = itemView.findViewById(R.id.quantitySpinner);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
            addToFavoritesButton = itemView.findViewById(R.id.addToFavoritesButton);
        }
    }
}
