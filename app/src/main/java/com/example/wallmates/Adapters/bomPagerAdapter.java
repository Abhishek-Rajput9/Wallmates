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
import com.example.wallmates.Modals.bomModal;
import com.example.wallmates.R;
import com.example.wallmates.databinding.PagerViewholderBinding;

import java.util.ArrayList;

public class bomPagerAdapter extends RecyclerView.Adapter<bomPagerAdapter.ViewHolder> {
    Context context;
    ArrayList<bomModal> bomModalArrayList   ;

    public bomPagerAdapter(Context context, ArrayList<bomModal> bomModalArrayList) {
        this.context = context;
        this.bomModalArrayList = bomModalArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pager_viewholder,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        bomModal bomModal = bomModalArrayList.get(position);
        Glide.with(context).load(bomModal.getImage()).into(holder.binding.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, detailActivity.class);
                intent.putExtra("img",bomModal.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bomModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        PagerViewholderBinding binding  ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding  = PagerViewholderBinding.bind(itemView);
        }
    }
}
