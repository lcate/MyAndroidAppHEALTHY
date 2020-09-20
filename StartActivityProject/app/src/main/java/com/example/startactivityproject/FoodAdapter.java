package com.example.startactivityproject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.startactivityproject.R;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.DetailsViewHolder> {
    ArrayList<String> ingredients;

    public FoodAdapter(ArrayList<String> listaVezbi) {
        ingredients=listaVezbi;
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {
        public TextView ingredient;

        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredient = itemView.findViewById(R.id.text);
        }
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodexampleitem,parent,false);
        DetailsViewHolder dvh=new DetailsViewHolder(v);
        return dvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        String currentItem=ingredients.get(position);
        holder.ingredient.setText(currentItem);
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }
}
