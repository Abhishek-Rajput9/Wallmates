package com.example.wallmates.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wallmates.Activity.bomPagerActivity;
import com.example.wallmates.Modals.bomModal;
import com.example.wallmates.R;
import com.example.wallmates.databinding.BomViewholderBinding;

import java.util.ArrayList;

public class bomAdapter extends RecyclerView.Adapter<bomAdapter.ViewHolder> {
    Context context;
    ArrayList<bomModal> bomModalArrayList;

    public bomAdapter(Context context, ArrayList<bomModal> bomModalArrayList) {
        this.context = context;
        this.bomModalArrayList = bomModalArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bom_viewholder,parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        bomModal bomModal = bomModalArrayList.get(position);
        Glide.with(context).load(bomModal.getImage()).into(holder.binding.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, bomPagerActivity.class);
                intent.putExtra("list1",bomModalArrayList);
                intent.putExtra("pos", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bomModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        BomViewholderBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = BomViewholderBinding.bind(itemView);
        }
    }
}
