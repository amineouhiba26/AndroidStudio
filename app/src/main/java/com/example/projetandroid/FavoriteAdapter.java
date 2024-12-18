package com.example.projetandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private List<Product> favoriteProducts;
    private Context context;

    public FavoriteAdapter(List<Product> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.favorites_item, parent, false);
        return new FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        Product product = favoriteProducts.get(position);

        holder.productName.setText(product.getName());
        holder.productPrice.setText(String.format("$%.2f", product.getPrice()));
        holder.productImage.setImageResource(product.getImageResourceId());


    }

    @Override
    public int getItemCount() {
        return favoriteProducts.size();
    }

    public static class FavoriteViewHolder extends RecyclerView.ViewHolder {

        TextView productName, productPrice;
        ImageView productImage;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.favoriteProductName);
            productPrice = itemView.findViewById(R.id.favoriteProductPrice);
            productImage = itemView.findViewById(R.id.favoriteProductImage);
        }
    }
}
