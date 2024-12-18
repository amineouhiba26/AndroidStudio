package com.example.projetandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private Context context;
    private List<Product> cartList;



    public CartAdapter(Context context, List<Product> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = cartList.get(position);

        // Set product image, name, price, quantity, and total
        holder.productImage.setImageResource(product.getImageResourceId()); // Replace with actual product image
        holder.productName.setText(product.getName());
        holder.productPrice.setText(String.format("$%.2f", product.getPrice()));
        holder.productQuantity.setText("Qty: " + product.getQuantity());
        holder.productTotal.setText(String.format("Total: $%.2f", product.getPrice() * product.getQuantity()));
        holder.deleteButton.setOnClickListener(v -> {
            // Remove the item from the list
            cartList.remove(position);
            // Notify the adapter about the removed item
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartList.size());
        });

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName, productPrice, productQuantity, productTotal;
        Button deleteButton; // Add Delete button reference



        public ViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.cartProductImage);
            productName = itemView.findViewById(R.id.cartProductName);
            productPrice = itemView.findViewById(R.id.cartProductPrice);
            productQuantity = itemView.findViewById(R.id.cartProductQuantity);
            productTotal = itemView.findViewById(R.id.cartProductTotal);
            deleteButton = itemView.findViewById(R.id.deleteButton);

        }
    }
}
