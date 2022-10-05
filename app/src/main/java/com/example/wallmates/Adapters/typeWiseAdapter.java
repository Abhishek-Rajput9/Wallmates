package com.example.wallmates.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wallmates.Activity.detailActivity;
import com.example.wallmates.Modals.typeWiseModal;
import com.example.wallmates.R;

import com.example.wallmates.databinding.TypewiseViewholderBinding;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class typeWiseAdapter extends RecyclerView.Adapter<typeWiseAdapter.ViewHolder> {
    Context context;
    ArrayList<typeWiseModal> typeWiseModalArrayList;

    public typeWiseAdapter(Context context, ArrayList<typeWiseModal> typeWiseModalArrayList) {
        this.context = context;
        this.typeWiseModalArrayList = typeWiseModalArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(context).inflate(R.layout.typewise_viewholder,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    typeWiseModal typeWiseModal = typeWiseModalArrayList.get(position);
        Glide.with(context ).load(typeWiseModal.getImage()).into(holder.binding.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, detailActivity.class);
                intent.putExtra("img",typeWiseModal.getImage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return typeWiseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
   TypewiseViewholderBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = TypewiseViewholderBinding.bind(itemView);
        }
    }
}
