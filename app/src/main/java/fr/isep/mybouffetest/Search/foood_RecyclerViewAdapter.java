package fr.isep.mybouffetest.Search;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.isep.mybouffetest.AddFood.UserAddFoodActivity;
import fr.isep.mybouffetest.R;

public class foood_RecyclerViewAdapter extends RecyclerView.Adapter<foood_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<FoodModel> foodModels;


    public foood_RecyclerViewAdapter(Context context, ArrayList<FoodModel> foodModels){
        this.context = context;
        this.foodModels = foodModels;
    }
    

    @NonNull
    @Override
    // look des rows
    public foood_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.recycler_view_row, parent, false);


        return new foood_RecyclerViewAdapter.MyViewHolder(view);
    }

    // assigner
    @Override
    public void onBindViewHolder(@NonNull foood_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.mTextView.setText(foodModels.get(position).getFoodName());
        holder.mImageView.setImageResource(foodModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return foodModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mTextView;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageFood);
            mTextView = itemView.findViewById(R.id.foodNameView);
        }
    }


}

