package com.example.wallmates.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallmates.Activity.typeWiseActivity;
import com.example.wallmates.Modals.colorModal;
import com.example.wallmates.R;
import com.example.wallmates.databinding.ColorViewholderBinding;

import java.util.ArrayList;

public class colorAdapter extends RecyclerView.Adapter<colorAdapter.ViewHolder> {
    Context context;
    ArrayList<colorModal> colorModalArrayList;

    public colorAdapter(Context context, ArrayList<colorModal> colorModalArrayList) {
        this.context = context;
        this.colorModalArrayList = colorModalArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.color_viewholder, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        colorModal colorModal = colorModalArrayList.get(position);
        holder.binding.name.setText(colorModal.getName());
        holder.binding.card.setCardBackgroundColor(Color.parseColor(colorModal.getColor()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent   = new Intent(context, typeWiseActivity.class);
                intent.putExtra("type",colorModal.getType());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return colorModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ColorViewholderBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ColorViewholderBinding.bind(itemView);
        }
    }
}
