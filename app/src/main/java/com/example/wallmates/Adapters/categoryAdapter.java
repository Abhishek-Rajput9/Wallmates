package com.example.wallmates.Adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wallmates.Activity.typeWiseActivity;
import com.example.wallmates.Modals.categoryModal;
import com.example.wallmates.R;
import com.example.wallmates.databinding.CategoryViewholderBinding;

import java.util.ArrayList;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.Viewholder> {
    Context context ;
    ArrayList<categoryModal>    categoryModalArrayList;

    public categoryAdapter(Context context, ArrayList<categoryModal> categoryModalArrayList) {
        this.context = context;
        this.categoryModalArrayList = categoryModalArrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_viewholder,parent, false );
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        categoryModal categoryModal = categoryModalArrayList.get(position);
        holder.binding.name.setText(categoryModal.getName());
        Glide.with(context).load(categoryModal.getImage()).into(holder.binding.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent   = new Intent(context, typeWiseActivity.class);
                intent.putExtra("type",categoryModal.getType());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryModalArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        CategoryViewholderBinding binding;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            binding = CategoryViewholderBinding.bind(itemView);
        }
    }
}
